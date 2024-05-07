package main.visitor.nameAnalyzer;

import main.ast.nodes.Program;
import main.ast.nodes.declaration.FunctionDeclaration;
import main.ast.nodes.declaration.MainDeclaration;
import main.ast.nodes.declaration.PatternDeclaration;
import main.ast.nodes.declaration.VarDeclaration;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.value.FunctionPointer;
import main.ast.nodes.expression.value.ListValue;
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

import java.sql.SQLOutput;
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
            SymbolTable.top.getVarItem(identifier.getName());
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
        Identifier functionName = functionDeclaration.getFunctionName();
        for (VarDeclaration arg : functionDeclaration.getArgs()) {
            if (arg.getName().getName().equals(functionName.getName())) {
                nameErrors.add(new IdenticalArgFunctionName(functionName.getLine(), arg.getName().getName()));
            }
        }
        functionDeclaration.getArgs().forEach(varDec -> varDec.accept(this));
        functionDeclaration.getBody().forEach(statement -> {
            statement.accept(this);
        });
        return null;
    }

    @Override
    public Void visit(PatternDeclaration patternDeclaration) {
        try {
            SymbolTable.top.put(new VarItem(patternDeclaration.getTargetVariable()));
        } catch (ItemAlreadyExists ignored) {}
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
        if (returnStatement.hasRetExpression())
            returnStatement.getReturnExp().accept(this);
        return null;
    }

    @Override
    public Void visit(IfStatement ifStatement) {
        ifStatement.getConditions().forEach(condition -> condition.accept(this));

        ifStatement.getThenBody().forEach(thenBody -> {
            SymbolTable.push();
            thenBody.accept(this);
            SymbolTable.pop();
        });

        ifStatement.getElseBody().forEach(elseBody -> {
            SymbolTable.push();
            elseBody.accept(this);
            SymbolTable.pop();
        });
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
        SymbolTable.push();
        loopDoStatement.getLoopConditions().forEach(condition -> condition.accept(this));
        loopDoStatement.getLoopBodyStmts().forEach(statement -> statement.accept(this));
        if (loopDoStatement.getLoopRetStmt() != null)
            loopDoStatement.getLoopRetStmt().accept(this);
        SymbolTable.pop();
        return null;
    }
    @Override
    public Void visit(ForStatement forStatement) {
        SymbolTable.push();
        forStatement.getRangeExpressions().forEach(expression -> expression.accept(this));
        forStatement.getLoopBody().forEach(statement -> statement.accept(this));
        forStatement.getLoopBodyExpressions().forEach(expression -> expression.accept(this));
        if (forStatement.hasReturnStatement())
            forStatement.getReturnStatement().accept(this);
        SymbolTable.pop();
        return null;
    }

    @Override
    public Void visit(MatchPatternStatement matchPatternStatement) {
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
        assignStatement.getAssignExpression().accept(this);
        if (assignStatement.isAccessList()) {
            assignStatement.getAccessListExpression().accept(this);
            assignStatement.getAssignedId().accept(this);
        } 
        else {
            var varItem = new VarItem(assignStatement.getAssignedId());
            try {
                SymbolTable.top.put(varItem);
            } catch (ItemAlreadyExists ignored) {
            }
        }
        return null;
    }

    @Override
    public Void visit(ExpressionStatement expressionStatement) {
        expressionStatement.getExpression().accept(this);
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
        if (accessExpression.getAccessedExpression() instanceof Identifier identifier &&
            accessExpression.startWithFunctionCall()) {
            try {
                FunctionItem functionItem = SymbolTable.root.getFunctionItem(identifier.getName());
                if(!functionItem.getFunctionDeclaration().matchArgs(accessExpression.numberOFArgs()))
                    nameErrors.add(new ArgMisMatch(identifier.getLine(), identifier.getName()));
                
            } catch (ItemNotFound e) {
                nameErrors.add(new FunctionNotDeclared(identifier.getLine(), identifier.getName()));
            }
        }
        else
            accessExpression.getAccessedExpression().accept(this);
        
        accessExpression.getAccesses().forEach(access -> access.accept(this));
        return null;
    }

    @Override
    public Void visit(LambdaExpression lambdaExpression) {
        lambdaExpression.getDeclarationArgs().forEach(varDeclaration -> varDeclaration.accept(this));
        lambdaExpression.getBody().forEach( statement -> {
            SymbolTable.push();
            statement.accept(this);
            SymbolTable.pop();
        });

        return null;
    }

    @Override
    public Void visit(ListValue listValue) {
        listValue.getElements().forEach(element -> element.accept(this));
        return null;
    }

    @Override
    public Void visit(FunctionPointer functionPointer) {
        Identifier identifier = functionPointer.getId();
        try {
            SymbolTable.root.getFunctionItem(identifier.getName());
        } catch (ItemNotFound e) {
            nameErrors.add(new FunctionNotDeclared(identifier.getLine(), identifier.getName()));
        }
        return null;
    }

    @Override
    public Void visit(ArgExpression argExpression) {
        argExpression.getArgs().forEach(arg -> arg.accept(this));
        return null;
    }
    @Override
    public Void visit(IndexExpression indexExpression) {
        indexExpression.getIndex().accept(this);
        return null;
    }
}
