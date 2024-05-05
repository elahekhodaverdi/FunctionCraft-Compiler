package main.ast.nodes.expression.value;

import lombok.Getter;
import main.ast.nodes.expression.Identifier;
import main.visitor.IVisitor;

@Getter
public class FunctionPointer extends Value{
    private Identifier id;
    public FunctionPointer(Identifier id){this.id = id;}

    @Override
    public String toString(){return "FunctionPointer:" + this.id.getName();}
    @Override
    public <T> T accept(IVisitor<T> visitor){return visitor.visit(this);}
}
