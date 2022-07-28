package com.tyldanny.javacalculator.operation;

import com.tyldanny.javacalculator.gui.GUI;

public class NegativePositiveOperation implements IOperation {
    private final GUI gui;

    public NegativePositiveOperation(GUI gui) {
        this.gui = gui;
    }

    @Override
    public void handle(String buttonText) {
        gui.setCurrentValue(gui.getCurrentValue() * -1);
        setDisplay(gui, gui.getCurrentValue() + "");
    }

    @Override
    public void setPreviousOperationType(GUI gui) {
        gui.setPreviousOperationType(OperationType.NEGATIVE_POSITIVE);
    }
}
