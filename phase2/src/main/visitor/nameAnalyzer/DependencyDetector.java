package main.visitor.nameAnalyzer;

import main.ast.nodes.Program;
import main.ast.nodes.declaration.FunctionDeclaration;
import main.ast.nodes.declaration.MainDeclaration;
import main.ast.nodes.declaration.VarDeclaration;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.value.ListValue;
import main.ast.nodes.statement.AssignStatement;
import main.ast.nodes.statement.ExpressionStatement;
import main.ast.nodes.statement.ForStatement;
import main.ast.nodes.statement.IfStatement;
import main.ast.nodes.statement.LoopDoStatement;
import main.ast.nodes.statement.PushStatement;
import main.ast.nodes.statement.PutStatement;
import main.ast.nodes.statement.ReturnStatement;
import main.ast.nodes.statement.Statement;
import main.compileError.CompileError;
import main.compileError.nameErrors.CircularDependency;
import main.visitor.Visitor;
import main.symbolTable.utils.Graph;

import java.util.ArrayList;
import java.util.List;

public class DependencyDetector extends Visitor<Void> {
    public ArrayList<CompileError> dependencyError = new ArrayList<>();
    private Graph dependencyGraph = new Graph();
    private String functionName;
    @Override
    public Void visit(Program program){
        for(FunctionDeclaration functionDeclaration : program.getFunctionDeclarations()){
            functionDeclaration.accept(this);
        }

        return null;
    }

    private void processExpression(Expression expr, ArrayList<String> dependencies) {
        if (expr != null) {
            findFunctionCalls(expr, dependencies);
        }
    }

    private void processStatement(Statement stmt, ArrayList<String> dependencies) {
        Expression firstExpr;
        if (stmt instanceof ExpressionStatement) {
            firstExpr = ((ExpressionStatement) stmt).getExpression();
        } else if (stmt instanceof ReturnStatement) {
            firstExpr = ((ReturnStatement) stmt).getReturnExp();
        } else if (stmt instanceof PutStatement) {
            firstExpr = ((PutStatement) stmt).getExpression();
        } else if (stmt instanceof AssignStatement) {
            firstExpr = ((AssignStatement) stmt).getAssignExpression();
        } else {
            firstExpr = ((PushStatement) stmt).getInitial();
        }

        Expression secondExpr = stmt instanceof PushStatement ?  ((PushStatement) stmt).getToBeAdded() :
                (stmt instanceof AssignStatement) ? ((AssignStatement) stmt).getAccessListExpression(): null;
        processExpression(firstExpr, dependencies);
        processExpression(secondExpr, dependencies);
        
    }

    public void findFunctionCalls(Expression expr, ArrayList<String> dependencies) {
        if (expr instanceof AccessExpression accessExpr) {
            Expression accessedExpression = accessExpr.getAccessedExpression();

            if (!accessExpr.getAccesses().isEmpty() && accessedExpression instanceof Identifier id && accessExpr.getAccesses().get(0) instanceof ArgExpression)
                dependencies.add(id.getName());
            else
                processExpression(accessedExpression, dependencies);
            accessExpr.getAccesses().forEach(access -> processExpression(access, dependencies));
        }

        if (expr instanceof MatchPatternStatement matchPatStm)
            processExpression(matchPatStm.getMatchArgument(), dependencies);

        if (expr instanceof UnaryExpression unaryExpr)
            processExpression(unaryExpr.getExpression(), dependencies);

        if (expr instanceof ArgExpression argExpr)
            argExpr.getArgs().forEach(expression -> processExpression(expression, dependencies));

        if (expr instanceof IndexExpression indExpr)
            processExpression(indExpr.getIndex(), dependencies);

        if (expr instanceof LenStatement lenExpr)
            processExpression(lenExpr.getExpression(), dependencies);  

        if (expr instanceof ChopStatement chopExpr)
            processExpression(chopExpr.getChopExpression(), dependencies);

        if (expr instanceof ChompStatement chompExpr)
            processExpression(chompExpr.getChompExpression(), dependencies);

        if (expr instanceof AppendExpression appendExpr) {
            processExpression(appendExpr.getAppendee(), dependencies);
            appendExpr.getAppendeds().forEach(appended -> processExpression(appended, dependencies));
        }

        if (expr instanceof BinaryExpression binaryExpr) {
            processExpression(binaryExpr.getFirstOperand(), dependencies);
            processExpression(binaryExpr.getSecondOperand(), dependencies);
        }
    }

    @Override
    public Void visit(FunctionDeclaration functionDeclaration) {
        functionName = functionDeclaration.getFunctionName().getName();
        functionDeclaration.getBody().forEach(stmt -> stmt.accept(this));
        return null;
    }

    
    @Override
    public Void visit(PutStatement putStatement){
        putStatement.getExpression().accept(this);
        return null;
    }
    @Override
    public Void visit(LenStatement lenStatement){
        lenStatement.getExpression().accept(this);
        return null;
    }

    @Override
    public Void visit(PushStatement pushStatement){
        pushStatement.getInitial().accept(this);
        pushStatement.getToBeAdded().accept(this);
        return null;
    }

    @Override
    public Void visit(ChopStatement chopStatement){
        chopStatement.getChopExpression().accept(this);
        return null;   
    }

    @Override
    public Void visit(ChompStatement chompStatement){
        chompStatement.getChompExpression().accept(this);
        return null;
    }

    @Override
    public Void visit(MainDeclaration mainDeclaration){
        functionName = "main";
        mainDeclaration.getBody().forEach( stmt -> stmt.accept(this));
        return null;
    }

    @Override
    public Void visit(AccessExpression accessExpression){
        if (!accessExpression.getAccesses().isEmpty() && accessExpression.getAccessedExpression() instanceof Identifier id && accessExpression.getAccesses().get(0) instanceof ArgExpression)
            dependencyGraph.addEdge(functionName, id.getName());
        
        // accessExpression.getAccessedExpression().accpet(this); TODO
        accessExpression.getAccesses().forEach(access -> access.accept(this));
        return null;
    }

    @Override
    public Void visit(ListValue listValue){
        listValue.getElements().forEach(element -> element.accept(this));
        return null;
    }

    @Override
    public Void visit(AppendExpression appendExpression){
        appendExpression.getAppendee().accept(this);
        appendExpression.getAppendeds().forEach(appended -> appended.accept(this));
        return null;
    }

    @Override
    public Void visit(BinaryExpression binaryExpression){
        binaryExpression.getFirstOperand().accept(this);
        binaryExpression.getSecondOperand().accept(this);
        return null;
    }

    @Override
    public Void visit(UnaryExpression unaryExpression){
        unaryExpression.getExpression().accept(this);
        return null;
    }

    @Override
    public Void visit(ArgExpression argExpression){
        argExpression.getArgs().forEach(expression -> expression.accept(this));
        return null;
    }

    @Override
    public Void visit(IndexExpression indexExpression){
        indexExpression.getIndex().accept(this);
        return null;
    }

    @Override
    public Void visit(VarDeclaration varDeclaration){
        varDeclaration.getDefaultVal().accept(this);
        return null;
    }


    @Override
    public Void visit(ReturnStatement returnStatement){
        returnStatement.getReturnExp().accept(this);
        return null;
    }

    @Override
    public Void visit(IfStatement ifStatement){
        ifStatement.getConditions().forEach( condition -> condition.accept(this));
        return null;
    }
   
    @Override
    public Void visit(LoopDoStatement loopDoStatement){
        loopDoStatement.getLoopConditions().forEach(condition -> condition.accept(this));
        if (loopDoStatement.getLoopRetStmt() != null)
            loopDoStatement.getLoopRetStmt().accept(this);
        if (loopDoStatement.getLoopConditions().isEmpty())
            loopDoStatement.getLoopBodyStmts().forEach(stmt -> stmt.accept(this));
        return null;
    }

    @Override
    public Void visit(ForStatement forStatement){
        forStatement.getRangeExpressions().forEach( expr -> expr.accept(this));
        return null;
    }

    @Override
    public Void visit(MatchPatternStatement matchPatternStatement){
        matchPatternStatement.getMatchArgument().accept(this);
        return null;
    }

    @Override
    public Void visit(AssignStatement assignStatement){
        assignStatement.getAssignExpression().accept(this);
        assignStatement.getAccessListExpression().accept(this);
        return null;
    }

    @Override
    public Void visit(ExpressionStatement expressionStatement){
        expressionStatement.getExpression().accept(this);
        return null;
    }

    public Void findDependency(){
        ArrayList<List<String>> cycles = dependencyGraph.findCycles();
        if (cycles == null)
            return null;
        for(List<String> cycle : cycles) {
                dependencyError.add(new CircularDependency(cycle));
            }
        return null;
    }

}
