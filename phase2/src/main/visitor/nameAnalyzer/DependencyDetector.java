package main.visitor.nameAnalyzer;

import main.ast.nodes.Program;
import main.ast.nodes.declaration.FunctionDeclaration;
import main.ast.nodes.expression.AccessExpression;
import main.ast.nodes.expression.Expression;
import main.ast.nodes.expression.Identifier;
import main.ast.nodes.expression.LambdaExpression;
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
            dependencyGraph.addEdge("main", functionDeclaration.getFunctionName().getName());
            functionDeclaration.accept(this);
        }

        return null;
    }

    @Override
    public Void visit(FunctionDeclaration functionDeclaration) {
        String functionName = functionDeclaration.getFunctionName().getName();
        ArrayList<String> dependencies = new ArrayList<>();
        functionDeclaration.getBody().forEach(stmt -> {
            if (stmt instanceof ExpressionStatement expressionStatement) {
                Expression exp = expressionStatement.getExpression();
                if (exp instanceof AccessExpression accessExpression) {
                    Expression accessedExpression = accessExpression.getAccessedExpression(); 
                    if (accessedExpression instanceof Identifier id)
                        dependencies.add(id.getName());
                }
            }
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
