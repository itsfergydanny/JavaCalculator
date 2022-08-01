package com.tyldanny.javacalculator.operation;

import com.tyldanny.javacalculator.gui.GUI;

public class NegativePositiveOperation extends Operation {
    public NegativePositiveOperation(GUI gui, OperationType type) {
        super(gui, type);
    }

    public void handle(String buttonText) {
        if (getDisplay().contains("-")) {
            setDisplay(getDisplay().replace("-", ""));
            return;
        }
        setDisplay("-" + getDisplay());
    }
}
