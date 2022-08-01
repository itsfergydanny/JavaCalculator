package com.tyldanny.javacalculator.operation;

import com.tyldanny.javacalculator.gui.GUI;

public class PercentOperation extends Operation {
    public PercentOperation(GUI gui, OperationType type) {
        super(gui, type);
    }

    public void handle(String buttonText) {
        try {
            double currentValue = Double.parseDouble(getDisplay());
            setDisplay((currentValue / 100) + "");
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
    }
}
