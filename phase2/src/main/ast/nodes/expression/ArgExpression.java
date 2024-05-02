package main.ast.nodes.expression;

import main.visitor.IVisitor;

import java.util.ArrayList;

public class ArgExpression extends Expression{
    private ArrayList<Expression> arg;

    public ArgExpression(ArrayList<Expression> arg) {
        this.arg = arg;
    }

    @Override
    public String toString() {
        return "";
    }

    @Override
    public <T> T accept(IVisitor<T> visitor){return visitor.visit(this);}
}
