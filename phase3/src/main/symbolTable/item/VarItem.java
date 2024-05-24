package main.symbolTable.item;

import main.ast.nodes.expression.Identifier;
import main.ast.type.Type;

public class VarItem extends SymbolTableItem{
    public static String START_KEY = "VAR:";
    private Type type;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public VarItem(Identifier identifier){
        this.name = identifier.getName();
    }


    @Override
    public String getKey(){return START_KEY + this.name;}

    @Override
    public Object clone() {
        try {
            VarItem clone = (VarItem) super.clone();
            clone.name = this.name;
            clone.type = type;
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
