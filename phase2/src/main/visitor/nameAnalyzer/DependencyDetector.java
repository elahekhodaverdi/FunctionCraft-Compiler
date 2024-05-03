package main.visitor.nameAnalyzer;

import main.ast.nodes.Program;
import main.ast.nodes.declaration.FunctionDeclaration;
import main.ast.nodes.expression.*;
import main.ast.nodes.statement.ExpressionStatement;
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
    @Override
    public Void visit(Program program){
        for(FunctionDeclaration functionDeclaration : program.getFunctionDeclarations()){
            functionDeclaration.accept(this);
        }

        return null;
    }

    public void findFunctionCalls(Expression expr, ArrayList<String> dependencies) {
        if (expr instanceof AccessExpression accessExpr) {
            Expression accessedExpression = accessExpr.getAccessedExpression();
            if (accessExpr.getAccesses().size() == 0)
                return;
            if (accessedExpression instanceof Identifier id && accessExpr.getAccesses().get(0) instanceof ArgExpression) 
                    dependencies.add(id.getName());

            for (Expression expression : accessExpr.getAccesses())
                findFunctionCalls(expression, dependencies);
        }
        
        if (expr instanceof AppendExpression appendExpr) {
            Expression appendeeExpr = appendExpr.getAppendee(); 
            findFunctionCalls(appendeeExpr, dependencies);
            for (Expression expression : appendExpr.getAppendeds())
                findFunctionCalls(expression, dependencies);
        }

        if (expr instanceof BinaryExpression binaryExpr) {
            Expression firstExpr = binaryExpr.getFirstOperand(); 
            Expression secondExpr = binaryExpr.getSecondOperand(); 
            findFunctionCalls(firstExpr, dependencies);
            findFunctionCalls(secondExpr, dependencies);
        }
    }

    @Override
    public Void visit(FunctionDeclaration functionDeclaration) {
        String functionName = functionDeclaration.getFunctionName().getName();
        ArrayList<String> dependencies = new ArrayList<>();
        functionDeclaration.getBody().forEach(stmt -> {
            Expression exp;
            if (stmt instanceof ExpressionStatement exprStm) 
                exp = exprStm.getExpression();
            else if (stmt instanceof ReturnStatement retStm)
                exp = (retStm.hasRetExpression())? retStm.getReturnExp() : null;
            else
                return;
            if (exp == null) return;
            findFunctionCalls(exp, dependencies);
        });

        dependencies.forEach(dependency -> dependencyGraph.addEdge(functionName, dependency));
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
