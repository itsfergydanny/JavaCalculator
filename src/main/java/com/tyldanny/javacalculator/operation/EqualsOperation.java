package com.tyldanny.javacalculator.operation;

import com.tyldanny.javacalculator.gui.GUI;

public class EqualsOperation implements IOperation {
    private final GUI gui;

    public EqualsOperation(GUI gui) {
        this.gui = gui;
    }

    @Override
    public void handle(String buttonText) {
        if (gui.getPreviousValue() == null) {
            setHistory(gui, gui.getCurrentValue() + "");
            gui.setPreviousValue(gui.getCurrentValue());
            gui.setCurrentValue(0);
            setDisplay(gui, "0");
            return;
        }

        if (gui.getPreviousOperationType() == OperationType.ADDITION) {
            gui.setPreviousValue(gui.getPreviousValue() + gui.getCurrentValue());
        } else {
            gui.setPreviousValue(gui.getCurrentValue());
        }

        setHistory(gui, clean(gui.getPreviousValue() + ""));
        gui.setCurrentValue(0);
        setDisplay(gui, "0");
    }

    @Override
    public void setPreviousOperationType(GUI gui) {
        gui.setPreviousOperationType(OperationType.EQUALS);
    }
}
