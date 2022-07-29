package com.tyldanny.javacalculator.operation;

import com.tyldanny.javacalculator.gui.GUI;

public class MultiplicationOperation implements IOperation {
    private final GUI gui;

    public MultiplicationOperation(GUI gui) {
        this.gui = gui;
    }

    @Override
    public void handle(String buttonText) {
        if (gui.getPreviousValue() == null) {
            setHistory(gui, getDisplay(gui) + "X");
            gui.setPreviousValue(gui.getCurrentValue());
            gui.setCurrentValue(0d);
            setDisplay(gui, "0");
            return;
        }

        if (!getHistory(gui).contains("X")) {
            setHistory(gui, getHistory(gui) + "X");
            return;
        }

        gui.setPreviousValue(gui.getPreviousValue() * gui.getCurrentValue());
        setHistory(gui, clean(gui.getPreviousValue() + "") + "X");
        gui.setCurrentValue(0d);
        setDisplay(gui, "0");
    }

    @Override
    public void setPreviousOperationType(GUI gui) {
        gui.setPreviousOperationType(OperationType.MULTIPLICATION);
    }
}
