package src.main.compileError.nameErrors;

import src.main.compileError.CompileError;

public class ArgMisMatch extends CompileError {
    String functionName;
    public ArgMisMatch(int line, String functionName){
        this.line = line;
        this.functionName = functionName;
    }
    public String getErrorMessage(){return "Line:" + this.line + "-> number of arguments provided for function " + this.functionName + " does not match with its declaration";}
}
