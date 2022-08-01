package com.tyldanny.javacalculator.operation;

import com.tyldanny.javacalculator.gui.GUI;

public class NegativePositiveOperation implements IOperation {
    private final GUI gui;

    public NegativePositiveOperation(GUI gui) {
        this.gui = gui;
    }

    @Override
    public void handle(String buttonText) {
        if (getDisplay(gui).contains("-")) {
            setDisplay(gui, getDisplay(gui).replace("-", ""));
            return;
        }
        setDisplay(gui, "-" + getDisplay(gui));
    }
}
