package com.tyldanny.javacalculator.operation;

import com.tyldanny.javacalculator.gui.GUI;

public class AdditionOperation implements IOperation {
    private final GUI gui;

    public AdditionOperation(GUI gui) {
        this.gui = gui;
    }

    @Override
    public void handle(String buttonText) {
        if (gui.getPreviousValue() == null) {
            setHistory(gui, getDisplay(gui) + "+");
            gui.setPreviousValue(gui.getCurrentValue());
            gui.setCurrentValue(0);
            setDisplay(gui, "0");
            return;
        }

        gui.setPreviousValue(gui.getPreviousValue() + gui.getCurrentValue());
        setHistory(gui, clean(gui.getPreviousValue() + "") + "+");
        gui.setCurrentValue(0);
        setDisplay(gui, "0");
    }

    @Override
    public void setPreviousOperationType(GUI gui) {
        gui.setPreviousOperationType(OperationType.ADDITION);
    }
}
