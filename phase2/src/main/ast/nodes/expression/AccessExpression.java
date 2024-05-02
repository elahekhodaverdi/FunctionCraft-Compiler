package main.ast.nodes.expression;

import lombok.Getter;
import main.visitor.IVisitor;

import java.util.ArrayList;

@Getter
public class AccessExpression extends Expression{
    private Expression accessedExpression;
    private ArrayList<Expression> accesses = new ArrayList<>();

    public AccessExpression(Expression accessedExpression){
        this.accessedExpression = accessedExpression;
    }

    public void addAccess(Expression access) {
        accesses.add(access);
    }

    @Override
    public String toString(){return "AccessExpression";}
    @Override
    public <T> T accept(IVisitor<T> visitor){return visitor.visit(this);}
}
