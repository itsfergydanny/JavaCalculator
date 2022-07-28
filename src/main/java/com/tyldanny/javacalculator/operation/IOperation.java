package com.tyldanny.javacalculator.operation;

import com.tyldanny.javacalculator.gui.GUI;

public interface IOperation {
    void handle(String buttonText);

    default void setDisplay(GUI gui, String text) {
        gui.getDisplayPane().getField().setText(cleanOutput(text));
    }

    default String cleanOutput(String text) {
        if (text.endsWith(".0") || text.endsWith(".00")) {
            return text.split("\\.")[0];
        }
        return text;
    }
}
