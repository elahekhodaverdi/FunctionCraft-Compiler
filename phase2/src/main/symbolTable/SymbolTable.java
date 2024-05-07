package main.symbolTable;

import main.symbolTable.exceptions.ItemAlreadyExists;
import main.symbolTable.exceptions.ItemNotFound;
import main.symbolTable.item.FunctionItem;
import main.symbolTable.item.SymbolTableItem;
import main.symbolTable.item.VarItem;
import main.symbolTable.utils.Stack;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {
    public static SymbolTable top;
    public static SymbolTable root;
    private SymbolTable pre;
    private static Stack<SymbolTable> stack = new Stack<>();
    private Map<String, SymbolTableItem> items;
    public static void push(SymbolTable symbolTable) {
        symbolTable.pre = top;
        if (top != null)
            stack.push(top);
        top = symbolTable;
    }
    public static void pop() {
        top = stack.pop();
    }
    public SymbolTable() {
        this.items = new HashMap<>();
        this.pre = null;
    }
    public void put(SymbolTableItem item) throws ItemAlreadyExists {
        if (items.containsKey(item.getKey()))
            throw new ItemAlreadyExists();
        items.put(item.getKey(), item);
    }
    public SymbolTableItem getItem(String key) throws ItemNotFound {
        SymbolTable currentSymbolTable = this;
        SymbolTableItem symbolTableItem = null;

        while (symbolTableItem == null && currentSymbolTable != null) {
            symbolTableItem = currentSymbolTable.items.get(key);
            currentSymbolTable = currentSymbolTable.pre;
        }

        if( symbolTableItem == null )
            throw new ItemNotFound();

        return symbolTableItem;
    
    }

    public FunctionItem getFunctionItem(String key) throws ItemNotFound {
        return (FunctionItem) getItem(FunctionItem.START_KEY + key);
    }

    public VarItem getVarItem(String key) throws ItemNotFound {
        return (VarItem) getItem(VarItem.START_KEY + key);
    }
}
