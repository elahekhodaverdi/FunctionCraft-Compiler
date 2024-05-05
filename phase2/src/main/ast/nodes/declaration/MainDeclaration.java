package main.ast.nodes.declaration;

import lombok.Getter;
import lombok.Setter;
import main.ast.nodes.statement.Statement;
import main.visitor.IVisitor;

import java.util.ArrayList;

@Getter
@Setter
public class MainDeclaration extends Declaration{
    private ArrayList<Statement> body = new ArrayList<>();

    public void addBody(Statement stmt){this.body.add(stmt);}
    @Override
    public String toString(){return "MainDeclaration";}
    @Override
    public <T> T accept(IVisitor<T> visitor){return visitor.visit(this);}
}
