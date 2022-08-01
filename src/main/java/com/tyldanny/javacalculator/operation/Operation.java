package com.tyldanny.javacalculator.operation;

import com.tyldanny.javacalculator.gui.GUI;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class Operation {
    private GUI gui;
    private OperationType type;

    abstract public void handle(String buttonText);

    void setHistory(String text) {
        gui.getHistoryPane().getField().setText(text);
    }

    String getHistory() {
        return gui.getHistoryPane().getField().getText();
    }

    void setDisplay(String text) {
        gui.getDisplayPane().getField().setText(text);
    }

    String clean(String text) {
        if (text.endsWith(".0") || text.endsWith(".00")) {
            return text.split("\\.0+")[0];
        }
        return text;
    }

    String getDisplay() {
        return gui.getDisplayPane().getField().getText();
    }

    public GUI getGui() {
        return gui;
    }

    public OperationType getType() {
        return type;
    }
}
