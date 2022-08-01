package com.tyldanny.javacalculator.operation;

import com.tyldanny.javacalculator.gui.GUI;

public class PeriodOperation extends Operation {
    public PeriodOperation(GUI gui, OperationType type) {
        super(gui, type);
    }

    public void handle(String buttonText) {
        if (getDisplay().contains(".")) {
            return;
        }
        setDisplay(getDisplay() + ".");
    }
}
