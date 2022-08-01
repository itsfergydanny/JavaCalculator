package com.tyldanny.javacalculator.listeners;

import com.tyldanny.javacalculator.gui.GUI;
import com.tyldanny.javacalculator.operation.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonClickListener implements ActionListener {
    private final GUI gui;
    private final String buttonText;

    public ButtonClickListener(GUI gui, String buttonText) {
        this.gui = gui;
        this.buttonText = buttonText;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        OperationType operation = OperationType.getFromText(buttonText);
        if (operation == OperationType.NONE) {
            return;
        }
        if (!gui.getOPERATIONS().containsKey(operation)) {
            return;
        }
        gui.getOPERATIONS().get(operation).handle(buttonText);
    }
}
