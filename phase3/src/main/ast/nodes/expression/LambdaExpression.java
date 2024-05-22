package main.ast.nodes.expression;

import lombok.Getter;
import lombok.Setter;
import main.ast.nodes.declaration.VarDeclaration;
import main.ast.nodes.statement.Statement;
import main.visitor.IVisitor;

import java.util.ArrayList;

@Setter
@Getter
public class LambdaExpression extends Expression{
    ArrayList<VarDeclaration> declarationArgs = new ArrayList<>();
    ArrayList<Statement> body = new ArrayList<>();
    public LambdaExpression(ArrayList<VarDeclaration> declarationArgs, ArrayList<Statement> body
                            ){
        this.declarationArgs = declarationArgs;
        this.body = body;
    }

    public LambdaExpression(ArrayList<VarDeclaration> declarationArgs, ArrayList<Statement> body,
                            int line) {
        this.declarationArgs = declarationArgs;
        this.body = body;
        setLine(line);
    }

    @Override
    public String toString(){return "LambdaExpression";}
    @Override
    public <T> T accept(IVisitor<T> visitor){return visitor.visit(this);}
}
