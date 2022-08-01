package com.tyldanny.javacalculator.operation;

public enum OperationType {
    CLEAR("C"),
    NEGATIVE_POSITIVE("+/-"),
    PERCENT("%"),
    DIVISION("/"),
    MULTIPLICATION("X"),
    SUBTRACTION("-"),
    ADDITION("+"),
    PERIOD("."),
    EQUALS("="),
    DIGIT("0-9"),
    NONE("None");

    public final String label;

    OperationType(String label) {
        this.label = label;
    }

    public static OperationType getFromText(String text) {
        if (text.equals("C")) {
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
        if (text.equals("X")) {
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

        String regex = "[0-9]+";
        if (text.matches(regex)) {
            return DIGIT;
        }

        return NONE;
    }
}
