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

    private void processExpression(Expression expr, ArrayList<String> dependencies) {
        if (expr != null) {
            findFunctionCalls(expr, dependencies);
        }
    }

    public void findFunctionCalls(Expression expr, ArrayList<String> dependencies) {
        if (expr instanceof AccessExpression accessExpr) {
            Expression accessedExpression = accessExpr.getAccessedExpression();

            if (accessExpr.getAccesses().size() == 0 && !(accessedExpression instanceof MatchPatternStatement))
                return;
            if (accessedExpression instanceof MatchPatternStatement matchPatStm)
                processExpression(matchPatStm.getMatchArgument(), dependencies);
            if (accessedExpression instanceof Identifier id && accessExpr.getAccesses().get(0) instanceof ArgExpression) 
                dependencies.add(id.getName());
            accessExpr.getAccesses().forEach(access -> processExpression(access, dependencies));
        }

        if (expr instanceof UnaryExpression unaryExpr)
            processExpression(unaryExpr.getExpression(), dependencies);

        if (expr instanceof ArgExpression argExpr)
            argExpr.getArgs().forEach(expression -> processExpression(expression, dependencies));

        if (expr instanceof IndexExpression indExpr) {
            processExpression(indExpr.getIndex(), dependencies);
        }
        
        if (expr instanceof AppendExpression appendExpr) {
            Expression appendeeExpr = appendExpr.getAppendee();
            processExpression(appendeeExpr, dependencies);
            appendExpr.getAppendeds().forEach(appended -> processExpression(appended, dependencies));
        }

        if (expr instanceof BinaryExpression binaryExpr) {
            processExpression(binaryExpr.getFirstOperand(), dependencies);
            processExpression(binaryExpr.getSecondOperand(), dependencies);
        }
    }

    @Override
    public Void visit(FunctionDeclaration functionDeclaration) {
        String functionName = functionDeclaration.getFunctionName().getName();
        ArrayList<String> dependencies = new ArrayList<>();
        functionDeclaration.getBody().stream()
                .filter(stmt -> stmt instanceof ExpressionStatement ||
                        (stmt instanceof ReturnStatement && ((ReturnStatement) stmt).hasRetExpression()))
                .forEach(stmt -> {
                    Expression exp = stmt instanceof ExpressionStatement ? ((ExpressionStatement) stmt).getExpression()
                            : ((ReturnStatement) stmt).getReturnExp();
                    processExpression(exp, dependencies);
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
