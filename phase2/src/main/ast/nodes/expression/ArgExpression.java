package main.ast.nodes.expression;

import lombok.Getter;
import main.visitor.IVisitor;

import java.util.ArrayList;

@Getter
public class ArgExpression extends Expression{
    private ArrayList<Expression> args;

    public ArgExpression(ArrayList<Expression> args) {
        this.args = args;
    }

    @Override
    public String toString() {
        return "";
    }

    @Override
    public <T> T accept(IVisitor<T> visitor){return visitor.visit(this);}
}
