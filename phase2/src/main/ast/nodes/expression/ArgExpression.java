package main.ast.nodes.expression;

import lombok.Getter;
import main.visitor.IVisitor;

import java.util.ArrayList;

@Getter
public class ArgExpression extends Expression{
    private ArrayList<Expression> args;

    public ArgExpression(ArrayList<Expression> args, int line) {
        this.args = args;
        setLine(line);
    }

    @Override
    public String toString() {
        return args.toString();
    }

    @Override
    public <T> T accept(IVisitor<T> visitor){return visitor.visit(this);}
}
