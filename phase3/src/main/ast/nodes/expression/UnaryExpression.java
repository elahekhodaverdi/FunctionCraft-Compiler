package main.ast.nodes.expression;

import lombok.Getter;
import lombok.Setter;
import main.ast.nodes.expression.operators.UnaryOperator;
import main.visitor.IVisitor;

@Getter
@Setter
public class UnaryExpression extends Expression{
    private Expression expression;
    private UnaryOperator op;
    public UnaryExpression(Expression expression, UnaryOperator op){
        this.expression = expression;
        this.op = op;
    }

    @Override
    public String toString(){return "UnaryExpression_" + op.name();}
    @Override
    public <T> T accept(IVisitor<T> visitor){return visitor.visit(this);}
}
