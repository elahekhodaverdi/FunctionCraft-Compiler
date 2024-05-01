package src.main.compileError.nameErrors;

import src.main.compileError.CompileError;

public class RedefinitionOfPattern extends CompileError {
    String name;
    public RedefinitionOfPattern(int line, String name){
        this.line = line;
        this.name = name;
    }
    public String getErrorMessage(){return "Line:" + this.line + "-> Redefinition of pattern " + this.name;}
}

