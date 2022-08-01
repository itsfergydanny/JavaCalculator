package com.tyldanny.javacalculator.operation;

import com.tyldanny.javacalculator.gui.GUI;

public class ClearOperation extends Operation {
    public ClearOperation(GUI gui, OperationType type) {
        super(gui, type);
    }

    public void handle(String buttonText) {
        setHistory("0");
        setDisplay("0");
    }
}
