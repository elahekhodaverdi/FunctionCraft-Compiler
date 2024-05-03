package main.ast.nodes.expression;

import lombok.Getter;
import main.visitor.IVisitor;

@Getter
public class IndexExpression extends Expression{
    Expression index;

    public IndexExpression(Expression index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "";
    }

    @Override
    public <T> T accept(IVisitor<T> visitor){return visitor.visit(this);}
}
