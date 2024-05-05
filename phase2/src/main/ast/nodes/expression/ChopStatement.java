package main.ast.nodes.expression;

import lombok.Getter;
import main.visitor.IVisitor;

@Getter
public class ChopStatement extends Expression{
    private Expression chopExpression;
    public ChopStatement(Expression chopExpression){this.chopExpression = chopExpression;}

    @Override
    public String toString(){return "ChopStatement";}
    @Override
    public <T> T accept(IVisitor<T> visitor){return visitor.visit(this);}
}
