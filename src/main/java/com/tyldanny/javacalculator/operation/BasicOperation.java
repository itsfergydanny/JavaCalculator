package com.tyldanny.javacalculator.operation;

import com.tyldanny.javacalculator.gui.GUI;

public class BasicOperation extends Operation {
    public BasicOperation(GUI gui, OperationType type) {
        super(gui, type);
    }

    public void handle(String buttonText) {
        if (getHistory().contains(getType().label)) {
            try {
                double previousValue = Double.parseDouble(getHistory().replace(getType().label, ""));
                double nextValue = Double.parseDouble(getDisplay());
                handleDifferentOperations(previousValue, nextValue);
                setDisplay("0");
                return;
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
            return;
        }

        setHistory(getHistory().replaceAll("[^0-9]", ""));

        if (!getHistory().equals("0")) {
            setHistory(getHistory() + getType().label);
            return;
        }

        setHistory(getDisplay() + getType().label);
        setDisplay("0");
    }

    private void handleDifferentOperations(double previousValue, double nextValue) {
        if (getType() == OperationType.ADDITION) {
            setHistory(clean((previousValue + nextValue) + "") + getType().label);
        } else if (getType() == OperationType.SUBTRACTION) {
            setHistory(clean((previousValue - nextValue) + "") + getType().label);
        } else if (getType() == OperationType.MULTIPLICATION) {
            setHistory(clean((previousValue * nextValue) + "") + getType().label);
        } else if (getType() == OperationType.DIVISION) {
            setHistory(clean((previousValue / nextValue) + "") + getType().label);
        }
    }
}
