package src.main.ast.nodes.expression.value.primitive;

import src.main.ast.nodes.expression.value.Value;
import src.main.visitor.IVisitor;

public class BoolValue extends Value {
    private Boolean bool;
    public BoolValue(Boolean bool){this.bool = bool;}

    public Boolean getBool() {
        return bool;
    }

    public void setBool(Boolean bool) {
        this.bool = bool;
    }
    @Override
    public String toString(){return "BoolValue:" + this.bool;}
    @Override
    public <T> T accept(IVisitor<T> visitor){return visitor.visit(this);}
}
