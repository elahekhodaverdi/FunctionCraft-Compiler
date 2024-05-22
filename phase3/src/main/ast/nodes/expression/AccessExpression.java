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

    public boolean startWithFunctionCall() {
        if (!accesses.isEmpty())
            return accesses.getFirst() instanceof ArgExpression;
        return false;
    }

    public int numberOFArgs() {
        if (startWithFunctionCall()) {
            ArgExpression argExpression = (ArgExpression) accesses.getFirst();
            return argExpression.getArgs().size();
        }
        return 0;
    }

    public void addAccess(Expression access) {
        accesses.add(access);
    }

    @Override
    public String toString(){return "AccessExpression";}
    @Override
    public <T> T accept(IVisitor<T> visitor){return visitor.visit(this);}
}
