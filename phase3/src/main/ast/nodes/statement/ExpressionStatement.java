package main.ast.nodes.statement;

import lombok.Getter;
import lombok.Setter;
import main.ast.nodes.expression.Expression;
import main.visitor.IVisitor;

@Getter
@Setter
public class ExpressionStatement extends Statement{
    private Expression expression;
    public ExpressionStatement(Expression expression){this.expression = expression;}

    @Override
    public String toString(){return "ExpressionStatement";}
    @Override
    public <T> T accept(IVisitor<T> visitor){return visitor.visit(this);}
}
