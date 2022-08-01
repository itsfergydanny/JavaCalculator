package com.tyldanny.javacalculator.operation;

import com.tyldanny.javacalculator.gui.GUI;

public class PeriodOperation implements IOperation {
    private final GUI gui;

    public PeriodOperation(GUI gui) {
        this.gui = gui;
    }

    @Override
    public void handle(String buttonText) {
        if (getDisplay(gui).contains(".")) {
            return;
        }
        setDisplay(gui, getDisplay(gui) + ".");
    }
}
