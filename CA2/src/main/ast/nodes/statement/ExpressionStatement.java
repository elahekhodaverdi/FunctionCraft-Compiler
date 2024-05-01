package src.main.ast.nodes.statement;

import src.main.ast.nodes.expression.Expression;
import src.main.visitor.IVisitor;

public class ExpressionStatement extends Statement{
    private Expression expression;
    public ExpressionStatement(Expression expression){this.expression = expression;}

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }
    @Override
    public String toString(){return "ExpressionStatement";}
    @Override
    public <T> T accept(IVisitor<T> visitor){return visitor.visit(this);}
}
