package src.main.symbolTable.item;

import src.main.ast.nodes.expression.Identifier;

public class VarItem extends SymbolTableItem{
    public static String START_KEY = "VAR:";
    public VarItem(Identifier identifier){
        this.name = identifier.getName();
    }
    @Override
    public String getKey(){return START_KEY + this.name;}
}
