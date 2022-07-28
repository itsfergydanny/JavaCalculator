package com.tyldanny.javacalculator.operation;

import com.tyldanny.javacalculator.gui.GUI;

public class ClearOperation implements IOperation {
    private final GUI gui;

    public ClearOperation(GUI gui) {
        this.gui = gui;
    }

    @Override
    public void handle(String buttonText) {
        gui.setCurrentValue(0);
        setDisplay(gui, "0");
        gui.setPreviousValue(null);
        setHistory(gui, "0");
    }

    @Override
    public void setPreviousOperationType(GUI gui) {
        gui.setPreviousOperationType(OperationType.CLEAR);
    }
}
