package com.tyldanny.javacalculator.operation;

import com.tyldanny.javacalculator.gui.GUI;

public class AdditionOperation implements IOperation {
    private final GUI gui;

    public AdditionOperation(GUI gui) {
        this.gui = gui;
    }

    @Override
    public void handle(String buttonText) {
        if (getHistory(gui).contains("+")) {
            try {
                double previousValue = Double.parseDouble(getHistory(gui).replace("+", ""));
                double nextValue = Double.parseDouble(getDisplay(gui));
                setHistory(gui, clean((previousValue + nextValue) + "") + "+");
                setDisplay(gui, "0");
                return;
            } catch (NumberFormatException ignore) {}
            return;
        }

        if (!getHistory(gui).equals("0")) {
            setHistory(gui, getHistory(gui) + "+");
            return;
        }

        setHistory(gui, getDisplay(gui) + "+");
        setDisplay(gui, "0");
    }
}
