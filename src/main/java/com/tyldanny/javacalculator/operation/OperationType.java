package com.tyldanny.javacalculator.operation;

public enum OperationType {
    CLEAR("C"),
    NEGATIVE_POSITIVE("+/-"),
    PERCENT("%"),
    DIVISION("/"),
    MULTIPLICATION("*"),
    SUBTRACTION("-"),
    ADDITION("+"),
    PERIOD("."),
    EQUALS("="),
    DIGIT("0-9"),
    DEL("DEL"),
    NONE("NONE");

    public final String label;

    OperationType(String label) {
        this.label = label;
    }

    public static OperationType getFromText(String text) {
        if (text.equalsIgnoreCase("C")) {
            return CLEAR;
        }
        if (text.equals("+/-")) {
            return NEGATIVE_POSITIVE;
        }
        if (text.equals("%")) {
            return PERCENT;
        }
        if (text.equals("/")) {
            return DIVISION;
        }
        if (text.equals("*")) {
            return MULTIPLICATION;
        }
        if (text.equals("-")) {
            return SUBTRACTION;
        }
        if (text.equals("+")) {
            return ADDITION;
        }
        if (text.equals(".")) {
            return PERIOD;
        }
        if (text.equals("=")) {
            return EQUALS;
        }
        if (text.equals("DEL")) {
            return DEL;
        }

        String regex = "[0-9]+";
        if (text.matches(regex)) {
            return DIGIT;
        }

        return NONE;
    }
}
