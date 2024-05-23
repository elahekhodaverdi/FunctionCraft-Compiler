package main.ast.nodes.expression.operators;

import main.ast.type.NoType;
import main.ast.type.Type;
import main.ast.type.primitiveType.FloatType;
import main.ast.type.primitiveType.IntType;

public enum BinaryOperator {
    EQUAL, NOT_EQUAL, GREATER_THAN, LESS_THAN, LESS_EQUAL_THAN, GREATER_EQUAL_THAN, PLUS, MINUS, MULT, DIVIDE;

    public boolean support(Type type) {
        return type instanceof IntType || type instanceof FloatType || type instanceof NoType;
    }

    public boolean isArithmetic() {
        return this == PLUS || this == MINUS || this == MULT || this == DIVIDE;
    }
}
