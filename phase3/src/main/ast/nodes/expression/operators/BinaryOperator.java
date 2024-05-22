package main.ast.nodes.expression.operators;

public enum BinaryOperator {
    EQUAL, NOT_EQUAL, GREATER_THAN, LESS_THAN, LESS_EQUAL_THAN, GREATER_EQUAL_THAN, PLUS, MINUS, MULT, DIVIDE;

    public static boolean isEqualityOperator(BinaryOperator operator) {
        return operator == EQUAL || operator == NOT_EQUAL;
    }

    public static boolean isArithmeticOperator(BinaryOperator operator) {
        return operator == PLUS || operator == MINUS || operator == MULT || operator == DIVIDE;
    }
}
