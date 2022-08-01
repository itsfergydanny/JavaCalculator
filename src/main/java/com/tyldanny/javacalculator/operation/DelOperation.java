package com.tyldanny.javacalculator.operation;

import com.tyldanny.javacalculator.gui.GUI;

public class DelOperation extends Operation {
    public DelOperation(GUI gui, OperationType type) {
        super(gui, type);
    }

    public void handle(String buttonText) {
        if (getDisplay().length() < 2) {
            setDisplay("0");
            return;
        }

        setDisplay(getDisplay().substring(0, getDisplay().length() - 1));
    }
}
