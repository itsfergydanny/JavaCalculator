package com.tyldanny.javacalculator.operation;

import com.tyldanny.javacalculator.gui.GUI;

public class EqualsOperation implements IOperation {
    private final GUI gui;

    public EqualsOperation(GUI gui) {
        this.gui = gui;
    }

    @Override
    public void handle(String buttonText) {
        try {
            String history = getHistory(gui);

            double previousValue;
            double nextValue = Double.parseDouble(getDisplay(gui));

            if (history.contains("+")) {
                history = history.replace("+", "");
                previousValue = Double.parseDouble(history);
                setHistory(gui, clean((previousValue + nextValue) + ""));
                setDisplay(gui, "0");
            } else if (history.contains("/")) {
                history = history.replace("/", "");
                previousValue = Double.parseDouble(history);
                setHistory(gui, clean((previousValue / nextValue) + ""));
                setDisplay(gui, "0");
            } else if (history.contains("X")) {
                history = history.replace("X", "");
                previousValue = Double.parseDouble(history);
                setHistory(gui, clean((previousValue * nextValue) + ""));
                setDisplay(gui, "0");
            } else if (history.contains("-")) {
                history = history.replace("-", "");
                previousValue = Double.parseDouble(history);
                setHistory(gui, clean((previousValue - nextValue) + ""));
                setDisplay(gui, "0");
            }
        } catch (NumberFormatException ignore) {ignore.printStackTrace();}
    }
}
