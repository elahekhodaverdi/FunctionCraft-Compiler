package main.compileError.typeErrors;

import main.ast.nodes.expression.operators.BinaryOperator;
import main.compileError.CompileError;

public class UnsupportedOperandType extends CompileError {
    private final BinaryOperator operator;
    public UnsupportedOperandType(int line, BinaryOperator operator){
        this.line = line;
        this.operator = operator;
    }
    public String getErrorMessage(){return "Line:" + this.line + "-> unsupported operand type for operator " + operator;}
}