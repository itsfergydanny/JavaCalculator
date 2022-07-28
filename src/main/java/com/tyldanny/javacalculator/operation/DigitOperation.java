package com.tyldanny.javacalculator.operation;

import com.tyldanny.javacalculator.gui.GUI;

public class DigitOperation implements IOperation {
    private final GUI gui;

    public DigitOperation(GUI gui) {
        this.gui = gui;
    }

    @Override
    public void handle(String buttonText) {
        try {
            double val = Double.parseDouble(buttonText);
            String result;
            if (gui.getCurrentValue() == 0) {
                result = val + "";
            } else {
                String temp = gui.getCurrentValue() + "";
                if (temp.contains(".")) {
                    temp = temp.split("\\.")[0] + buttonText + "." + temp.split("\\.")[1];
                }
                result = temp;
            }

            gui.setCurrentValue(Double.parseDouble(result));

            setDisplay(gui, result);
        } catch (NumberFormatException ignore) {}
    }
}
