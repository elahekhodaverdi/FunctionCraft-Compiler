package main.visitor.nameAnalyzer;

import main.ast.nodes.Program;
import main.ast.nodes.declaration.FunctionDeclaration;
import main.ast.nodes.declaration.MainDeclaration;
import main.ast.nodes.declaration.PatternDeclaration;
import main.ast.nodes.declaration.VarDeclaration;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.value.FunctionPointer;
import main.ast.nodes.expression.value.ListValue;
import main.ast.nodes.expression.value.primitive.BoolValue;
import main.ast.nodes.expression.value.primitive.FloatValue;
import main.ast.nodes.expression.value.primitive.IntValue;
import main.ast.nodes.expression.value.primitive.StringValue;
import main.ast.nodes.statement.*;
import main.compileError.CompileError;
import main.compileError.nameErrors.*;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemAlreadyExists;
import main.symbolTable.exceptions.ItemNotFound;
import main.symbolTable.item.FunctionItem;
import main.symbolTable.item.PatternItem;
import main.symbolTable.item.VarItem;
import main.visitor.Visitor;

import java.util.ArrayList;

public class NameAnalyzer extends Visitor<Void> {
    public ArrayList<CompileError> nameErrors = new ArrayList<>();
    @Override
    public Void visit(Program program) {
        SymbolTable.root = new SymbolTable();
        SymbolTable.top = new SymbolTable();

        int duplicateFunctionId = 0;
        ArrayList<FunctionItem> functionItems = new ArrayList<>();
        for (FunctionDeclaration functionDeclaration : program.getFunctionDeclarations()) {
            FunctionItem functionItem = new FunctionItem(functionDeclaration);
            try {
                SymbolTable.root.put(functionItem);
                functionItems.add(functionItem);

            } catch (ItemAlreadyExists e) {
                nameErrors.add(new RedefinitionOfFunction(functionDeclaration.getLine(),
                         functionDeclaration.getFunctionName().getName()));
                duplicateFunctionId += 1;
                String freshName = functionItem.getName() + "#" + String.valueOf(duplicateFunctionId);
                Identifier newId = functionDeclaration.getFunctionName();
                newId.setName(freshName);
                functionDeclaration.setFunctionName(newId);
                FunctionItem newItem = new FunctionItem(functionDeclaration);
                functionItems.add(newItem);
                try {
                    SymbolTable.root.put(newItem);
                } catch (ItemAlreadyExists ignored) {}

            }
        }
        //addPatterns
        int duplicatePatternId = 0;
        ArrayList<PatternItem> patternItems = new ArrayList<>();
        for (PatternDeclaration patternDeclaration : program.getPatternDeclarations()) {
            PatternItem patternItem = new PatternItem(patternDeclaration);
            try {
                SymbolTable.root.put(patternItem);
                patternItems.add(patternItem);
            } catch (ItemAlreadyExists e) {
                nameErrors.add(new RedefinitionOfPattern(patternDeclaration.getLine(),
                        patternDeclaration.getPatternName().getName()));
                duplicatePatternId += 1;
                String freshName = patternItem.getName() + "#" + String.valueOf(duplicatePatternId);
                Identifier newId = patternDeclaration.getPatternName();
                newId.setName(freshName);
                patternDeclaration.setPatternName(newId);
                PatternItem newItem = new PatternItem(patternDeclaration);
                patternItems.add(newItem);
                try {
                    SymbolTable.root.put(newItem);
                } catch (ItemAlreadyExists ignored) {}
            }
        }

        int visitingFunctionIndex = 0;
        for (FunctionDeclaration functionDeclaration : program.getFunctionDeclarations()) {
            FunctionItem functionItem = functionItems.get(visitingFunctionIndex);
            SymbolTable functionSymbolTable = new SymbolTable();
            functionItem.setFunctionSymbolTable(functionSymbolTable);
            SymbolTable.push(functionSymbolTable);
            functionDeclaration.accept(this);
            SymbolTable.pop();
            visitingFunctionIndex += 1;
        }
        //visitPatterns
        int visitingPatternIndex = 0;
        for (PatternDeclaration patternDeclaration : program.getPatternDeclarations()) {
            PatternItem patternItem = patternItems.get(visitingPatternIndex);
            SymbolTable patternSymbolTable = new SymbolTable();
            patternItem.setPatternSymbolTable(patternSymbolTable);
            SymbolTable.push(patternSymbolTable);
            patternDeclaration.accept(this);
            SymbolTable.pop();
            visitingPatternIndex += 1;
        }
        //visitMain
        program.getMain().accept(this);
        return null;
    }

    @Override
    public Void visit(Identifier identifier) {
        try {
            SymbolTable.top.getItem(identifier.getName());
        } catch (ItemNotFound e) {
            nameErrors.add(new VariableNotDeclared(identifier.getLine(), identifier.getName()));
        }
        return null;
    }

    @Override
    public Void visit(VarDeclaration varDeclaration){
        var varItem = new VarItem(varDeclaration.getName());
        try {
            SymbolTable.top.put(varItem);
        } catch (ItemAlreadyExists ignored) {}
        return null;
    }

    @Override
    public Void visit(FunctionDeclaration functionDeclaration){
        functionDeclaration.getFunctionName().accept(this);
        functionDeclaration.getArgs().forEach(varDec -> varDec.accept(this));
        functionDeclaration.getBody().forEach(statement -> statement.accept(this));
        return null;
    }

    @Override
    public Void visit(PatternDeclaration patternDeclaration) {
        patternDeclaration.getPatternName().accept(this);
        patternDeclaration.getTargetVariable().accept(this);
        patternDeclaration.getConditions().forEach(condition -> condition.accept(this));
        patternDeclaration.getReturnExp().forEach(exp -> exp.accept(this));
        return null;
    }

    @Override
    public Void visit(MainDeclaration mainDeclaration) {
        mainDeclaration.getBody().forEach(statement -> statement.accept(this));
        return null;
    }

    @Override
    public Void visit(ReturnStatement returnStatement) {
        returnStatement.accept(this);
        return null;
    }

    @Override
    public Void visit(IfStatement ifStatement) {
        ifStatement.getConditions().forEach(condition -> condition.accept(this));
        ifStatement.getThenBody().forEach(thenBody -> thenBody.accept(this));
        ifStatement.getElseBody().forEach(elseBody -> elseBody.accept(this));
        return null;
    }

    @Override
    public Void visit(PutStatement putStatement) {
        putStatement.getExpression().accept(this);
        return null;
    }

    @Override
    public Void visit(LenStatement lenStatement) {
        lenStatement.getExpression().accept(this);
        return null;
    }

    @Override
    public Void visit(PushStatement pushStatement) {
        pushStatement.getInitial().accept(this);
        pushStatement.getToBeAdded().accept(this);
        return null;
    }

    @Override
    public Void visit(LoopDoStatement loopDoStatement) {
        loopDoStatement.getLoopConditions().forEach(condition -> condition.accept(this));
        loopDoStatement.getLoopBodyStmts().forEach(statement -> statement.accept(this));
        loopDoStatement.getLoopRetStmt().accept(this);
        return null;
    }
    @Override
    public Void visit(ForStatement forStatement) {
        forStatement.getIteratorId().accept(this);
        forStatement.getLoopBody().forEach(statement -> statement.accept(this));
        forStatement.getLoopBodyExpressions().forEach(expression -> expression.accept(this));
        forStatement.getReturnStatement().accept(this);
        return null;
    }

    @Override
    public Void visit(MatchPatternStatement matchPatternStatement) {
        matchPatternStatement.getPatternId().accept(this);
        matchPatternStatement.getMatchArgument().accept(this);
        return null;
    }

    @Override
    public Void visit(ChopStatement chopStatement) {
        chopStatement.getChopExpression().accept(this);
        return null;
    }

    @Override
    public Void visit(ChompStatement chompStatement) {
        chompStatement.getChompExpression().accept(this);
        return null;
    }

    @Override
    public Void visit(AssignStatement assignStatement) {
        assignStatement.getAssignedId().accept(this);
        assignStatement.getAssignExpression().accept(this);
        if (assignStatement.isAccessList())
            assignStatement.getAccessListExpression().accept(this);
        return null;
    }

    @Override
    public Void visit(ExpressionStatement expressionStatement) {
        return null;
    }

    @Override
    public Void visit(AppendExpression appendExpression) {
        appendExpression.getAppendee().accept(this);
        appendExpression.getAppendeds().forEach(appended -> appended.accept(this));
        return null;
    }
    @Override
    public Void visit(BinaryExpression binaryExpression) {
        binaryExpression.getFirstOperand().accept(this);
        binaryExpression.getSecondOperand().accept(this);
        return null;
    }

    @Override
    public Void visit(UnaryExpression unaryExpression) {
        unaryExpression.getExpression().accept(this);
        return null;
    }

    @Override
    public Void visit(AccessExpression accessExpression) {
        accessExpression.getAccessedExpression().accept(this);
        if (accessExpression.isFunctionCall()) {
            if (accessExpression.getAccessedExpression() instanceof Identifier identifier) {
                try {
                    SymbolTable.root.getItem(identifier.getName());
                } catch (ItemNotFound e) {
                    nameErrors.add(new FunctionNotDeclared(identifier.getLine(), identifier.getName()));
                }

            }
            accessExpression.getArguments().forEach(arg -> arg.accept(this));
        }
        else
            accessExpression.getDimentionalAccess().forEach(dim -> dim.accept(this));
        return null;
    }

    @Override
    public Void visit(LambdaExpression lambdaExpression) {
        lambdaExpression.getDeclarationArgs().forEach(varDeclaration -> varDeclaration.accept(this));
        lambdaExpression.getBody().forEach(statement -> statement.accept(this));
        return null;
    }

    @Override
    public Void visit(ListValue listValue) {
        listValue.getElements().forEach(element -> element.accept(this));
        return null;
    }

    @Override
    public Void visit(FunctionPointer functionPointer) {
        functionPointer.getId().accept(this);
        return null;
    }
}
