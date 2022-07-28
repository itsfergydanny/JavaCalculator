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

    @Override
    public void setPreviousOperationType(GUI gui) {
        // dont set it here
    }

    private boolean isDigit(String buttonText) {
        try {
            Double.parseDouble(buttonText);
            return true;
        } catch (NumberFormatException ignore) {}
        return false;
    }

    private void addDigit(String buttonText) {
        double value = Double.parseDouble(buttonText);

        if (gui.getCurrentValue() == 0) {
            setDisplay(gui, buttonText);
            gui.setCurrentValue(value);
            return;
        }

        if (gui.hasPeriod()) {
            placeDigitAfterPeriod(value);
            return;
        }

        placeDigit(value);
    }

    private void placeDigit(double value) {
        String temp = getDisplay(gui) + value;
        gui.setCurrentValue(Double.parseDouble(temp));
        setDisplay(gui, clean(temp));
    }

    private void placeDigitAfterPeriod(double value) {
        String temp = getDisplay(gui);
        temp = temp + clean(value + "");
        gui.setCurrentValue(Double.parseDouble(temp));
        setDisplay(gui, temp);
    }
}
