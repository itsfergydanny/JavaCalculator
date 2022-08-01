package com.tyldanny.javacalculator.operation;

import com.tyldanny.javacalculator.gui.GUI;

public class MultiplicationOperation implements IOperation {
    private final GUI gui;

    public MultiplicationOperation(GUI gui) {
        this.gui = gui;
    }

    @Override
    public void handle(String buttonText) {
        if (getHistory(gui).contains("X")) {
            try {
                double previousValue = Double.parseDouble(getHistory(gui).replace("X", ""));
                double nextValue = Double.parseDouble(getDisplay(gui));
                setHistory(gui, clean((previousValue * nextValue) + "") + "X");
                setDisplay(gui, "0");
                return;
            } catch (NumberFormatException ignore) {}
            return;
        }

        setHistory(gui, getHistory(gui).replaceAll("[^0-9]", ""));

        if (!getHistory(gui).equals("0")) {
            setHistory(gui, getHistory(gui) + "X");
            return;
        }

        setHistory(gui, getDisplay(gui) + "X");
        setDisplay(gui, "0");
    }
}
