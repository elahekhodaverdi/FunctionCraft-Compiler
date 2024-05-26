package main.symbolTable.item;

import lombok.Setter;
import main.ast.nodes.declaration.FunctionDeclaration;
import main.ast.type.Type;
import main.symbolTable.SymbolTable;

import java.util.ArrayList;

public class FunctionItem extends SymbolTableItem{
    public static final String START_KEY = "Function:";
    private SymbolTable functionSymbolTable;
    private FunctionDeclaration functionDeclaration;
    private ArrayList<Type> argumentTypes = new ArrayList<>();
    @Setter
    private ArrayList<Type> defaultArgumentTypes = new ArrayList<>();

    public ArrayList<Type> getArgumentTypes() {
        int numOfDefaultArgs = defaultArgumentTypes.size();
        int startIndex = numOfDefaultArgs - (functionDeclaration.getArgs().size() - argumentTypes.size());
        argumentTypes.addAll(defaultArgumentTypes.subList(startIndex, numOfDefaultArgs));
        return argumentTypes;
    }

    public void setArgumentTypes(ArrayList<Type> argumentTypes) {
        this.argumentTypes = argumentTypes;
    }

    public FunctionItem(FunctionDeclaration functionDeclaration){
        this.functionDeclaration = functionDeclaration;
        this.name = this.functionDeclaration.getFunctionName().getName();
    }



    public SymbolTable getFunctionSymbolTable() {
        return functionSymbolTable;
    }

    public void setFunctionSymbolTable(SymbolTable functionSymbolTable) {
        this.functionSymbolTable = functionSymbolTable;
    }

    public FunctionDeclaration getFunctionDeclaration() {
        return functionDeclaration;
    }

    public void setFunctionDeclaration(FunctionDeclaration functionDeclaration) {
        this.functionDeclaration = functionDeclaration;
    }
    @Override
    public String getKey() {return START_KEY + this.name;}

}
