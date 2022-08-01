package com.tyldanny.javacalculator.operation;

import com.tyldanny.javacalculator.gui.GUI;

public class EqualsOperation extends Operation {
    public EqualsOperation(GUI gui, OperationType type) {
        super(gui, type);
    }

    public void handle(String buttonText) {
        String history = getHistory();

        if (!history.contains("+") && !history.contains("-") && !history.contains("/") && !history.contains("*")) {
            setHistory(getDisplay());
            setDisplay("0");
            return;
        }

        try {

            double previousValue;
            double nextValue = Double.parseDouble(getDisplay());

            if (history.contains("+")) {
                history = history.replace("+", "");
                previousValue = Double.parseDouble(history);
                setHistory(clean((previousValue + nextValue) + ""));
                setDisplay("0");
            } else if (history.contains("/")) {
                history = history.replace("/", "");
                previousValue = Double.parseDouble(history);
                setHistory(clean((previousValue / nextValue) + ""));
                setDisplay("0");
            } else if (history.contains("*")) {
                history = history.replace("*", "");
                previousValue = Double.parseDouble(history);
                setHistory(clean((previousValue * nextValue) + ""));
                setDisplay("0");
            } else if (history.contains("-")) {
                history = history.replace("-", "");
                previousValue = Double.parseDouble(history);
                setHistory(clean((previousValue - nextValue) + ""));
                setDisplay("0");
            }
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
    }
}
