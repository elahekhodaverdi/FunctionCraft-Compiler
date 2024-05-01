package src.main.visitor.nameAnalyzer;

import src.main.ast.nodes.Program;
import src.main.ast.nodes.declaration.FunctionDeclaration;
import src.main.ast.nodes.expression.AccessExpression;
import src.main.ast.nodes.expression.Expression;
import src.main.ast.nodes.expression.Identifier;
import src.main.ast.nodes.expression.LambdaExpression;
import src.main.ast.nodes.statement.ExpressionStatement;
import src.main.ast.nodes.statement.ReturnStatement;
import src.main.ast.nodes.statement.Statement;
import src.main.compileError.CompileError;
import src.main.compileError.nameErrors.CircularDependency;
import src.main.visitor.Visitor;
import src.main.symbolTable.utils.Graph;

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
    //TODO:visit function declarations and construct dependency graph
    public Void findDependency(){
        //TODO:find dependencies by analyzing dependency graph
        return null;
    }

}
