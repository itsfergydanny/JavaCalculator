package com.tyldanny.javacalculator.operation;

import com.tyldanny.javacalculator.gui.GUI;

public class PeriodOperation implements IOperation {
    private final GUI gui;

    public PeriodOperation(GUI gui) {
        this.gui = gui;
    }

    @Override
    public void handle(String buttonText) {
        if (!gui.hasPeriod()) {
            setDisplay(gui, getDisplay(gui) + ".");
        }
    }

    @Override
    public void setPreviousOperationType(GUI gui) {
        gui.setPreviousOperationType(OperationType.CLEAR);
    }
}
