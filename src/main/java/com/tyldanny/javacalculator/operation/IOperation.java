package com.tyldanny.javacalculator.operation;

import com.tyldanny.javacalculator.gui.GUI;

public interface IOperation {
    void handle(String buttonText);

    void setPreviousOperationType(GUI gui);

    default void setDisplay(GUI gui, String text) {
        gui.setHasPeriod(text.contains("."));
        gui.getDisplayPane().getField().setText(text);
    }

    default String getDisplay(GUI gui) {
        return gui.getDisplayPane().getField().getText();
    }
}
