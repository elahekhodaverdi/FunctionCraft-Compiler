package main.ast.nodes.expression;

import lombok.Getter;
import main.visitor.IVisitor;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Getter
public class AppendExpression extends Expression{
    private Expression appendee;
    private ArrayList<Expression> appendeds = new ArrayList<>();
    public AppendExpression(Expression appendee){this.appendee = appendee;}
    public void addAppendedExpression(Expression expression){this.appendeds.add(expression);}

    @Override
    public String toString(){return "AppendExpression";}
    @Override
    public <T> T accept(IVisitor<T> visitor){return visitor.visit(this);}
}
