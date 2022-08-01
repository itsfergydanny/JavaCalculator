package com.tyldanny.javacalculator.operation;

import com.tyldanny.javacalculator.gui.GUI;

public class DigitOperation implements IOperation {
    private final GUI gui;

    public DigitOperation(GUI gui) {
        this.gui = gui;
    }

    @Override
    public void handle(String buttonText) {
        if (!isDigit(buttonText)) {
            return;
        }
        addDigit(buttonText);
    }

    private boolean isDigit(String buttonText) {
        try {
            Double.parseDouble(buttonText);
            return true;
        } catch (NumberFormatException ignore) {}
        return false;
    }

    private void addDigit(String buttonText) {
        if (getDisplay(gui).charAt(0) == '0') {
            setDisplay(gui, buttonText);
            return;
        }
        double value = Double.parseDouble(buttonText);
        setDisplay(gui, getDisplay(gui) + clean(value + ""));
    }
}
