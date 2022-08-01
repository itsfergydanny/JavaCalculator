package com.tyldanny.javacalculator.operation;

import com.tyldanny.javacalculator.gui.GUI;

public class DigitOperation extends Operation {
    public DigitOperation(GUI gui, OperationType type) {
        super(gui, type);
    }

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
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    private void addDigit(String buttonText) {
        if (getDisplay().charAt(0) == '0') {
            setDisplay(buttonText);
            return;
        }
        double value = Double.parseDouble(buttonText);
        setDisplay(getDisplay() + clean(value + ""));
    }
}
