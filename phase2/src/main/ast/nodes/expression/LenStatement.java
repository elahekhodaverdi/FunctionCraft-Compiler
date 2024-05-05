package main.ast.nodes.expression;

import lombok.Getter;
import lombok.Setter;
import main.visitor.IVisitor;

@Getter
@Setter
public class LenStatement extends Expression{
    private Expression expression;
    public LenStatement(Expression expression){this.expression = expression;}

    @Override
    public String toString(){return "LenStatement";}
    @Override
    public <T> T accept(IVisitor<T> visitor){return visitor.visit(this);}
}
