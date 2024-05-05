package main.visitor.nameAnalyzer;

import main.ast.nodes.Program;
import main.ast.nodes.declaration.FunctionDeclaration;
import main.ast.nodes.expression.*;
import main.ast.nodes.statement.AssignStatement;
import main.ast.nodes.statement.ExpressionStatement;
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
        ArrayList<String> dependencies = new ArrayList<>();
        functionDeclaration.getBody().stream()
        .filter(stmt -> stmt instanceof ExpressionStatement ||
                (stmt instanceof ReturnStatement && ((ReturnStatement) stmt).hasRetExpression()) || 
                stmt instanceof PutStatement || stmt instanceof PushStatement || stmt instanceof AssignStatement)
        .forEach(stmt -> { processStatement(stmt, dependencies); });
    
        dependencies.forEach(dependency -> dependencyGraph.addEdge(functionName, dependency));
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
