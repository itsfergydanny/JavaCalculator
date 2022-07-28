package com.tyldanny.javacalculator.operation;

import com.tyldanny.javacalculator.gui.GUI;

public interface IOperation {
    void handle(String buttonText);

    void setPreviousOperationType(GUI gui);

    default void setHistory(GUI gui, String text) {
        gui.getHistoryPane().getField().setText(text);
    }

    default String getHistory(GUI gui) {
        return gui.getHistoryPane().getField().getText();
    }

    default void setDisplay(GUI gui, String text) {
        gui.setHasPeriod(text.contains("."));
        gui.getDisplayPane().getField().setText(text);
    }

    default String clean(String text) {
        if (text.endsWith(".0") || text.endsWith(".00")) {
            return text.split("\\.0+")[0];
        }
        return text;
    }

    default String getDisplay(GUI gui) {
        return gui.getDisplayPane().getField().getText();
    }
}
