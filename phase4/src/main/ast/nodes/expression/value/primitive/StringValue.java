package main.ast.nodes.expression.value.primitive;

import main.ast.nodes.expression.value.Value;
import main.visitor.IVisitor;

public class StringValue extends Value {
    private String str;
    public StringValue(String str){this.str = str.isEmpty()? str: str.substring(1, str.length()-1);}

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
    @Override
    public String toString(){return this.str;}
    @Override
    public <T> T accept(IVisitor<T> visitor){return visitor.visit(this);}
}
