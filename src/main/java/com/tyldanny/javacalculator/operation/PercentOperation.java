package com.tyldanny.javacalculator.operation;

import com.tyldanny.javacalculator.gui.GUI;

public class PercentOperation implements IOperation {
    private final GUI gui;

    public PercentOperation(GUI gui) {
        this.gui = gui;
    }

    @Override
    public void handle(String buttonText) {
        try {
            double currentValue = Double.parseDouble(getDisplay(gui));
            setDisplay(gui, (currentValue / 100) + "");
        } catch (NumberFormatException ignore) {}
    }
}
