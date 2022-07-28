package com.tyldanny.javacalculator.operation;

import com.tyldanny.javacalculator.gui.GUI;

public class PercentOperation implements IOperation {
    private final GUI gui;

    public PercentOperation(GUI gui) {
        this.gui = gui;
    }

    @Override
    public void handle(String buttonText) {
        gui.setCurrentValue(gui.getCurrentValue() / 100);
        setDisplay(gui, gui.getCurrentValue() + "");
    }

    @Override
    public void setPreviousOperationType(GUI gui) {
        gui.setPreviousOperationType(OperationType.PERCENT);
    }
}
