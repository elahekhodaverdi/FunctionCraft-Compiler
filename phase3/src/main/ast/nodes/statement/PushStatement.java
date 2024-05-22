package main.ast.nodes.statement;

import lombok.Getter;
import lombok.Setter;
import main.ast.nodes.expression.Expression;
import main.visitor.IVisitor;

@Getter
@Setter
public class PushStatement extends Statement{
    private Expression initial;
    private Expression toBeAdded;
    public PushStatement(Expression initial, Expression toBeAdded){
        this.initial = initial;
        this.toBeAdded = toBeAdded;
    }

    @Override
    public String toString(){return "PushStatement";}
    @Override
    public <T> T accept(IVisitor<T> visitor){return visitor.visit(this);}

}
