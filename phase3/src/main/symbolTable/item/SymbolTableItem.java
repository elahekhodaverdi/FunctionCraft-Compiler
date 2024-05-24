package main.symbolTable.item;

import main.symbolTable.SymbolTable;

public abstract class SymbolTableItem implements Cloneable{
    protected String name;
    public abstract String getKey();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
