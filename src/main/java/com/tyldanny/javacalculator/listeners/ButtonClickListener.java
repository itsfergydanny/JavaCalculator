package com.tyldanny.javacalculator.listeners;

import com.tyldanny.javacalculator.events.ButtonClickEvent;
import com.tyldanny.javacalculator.gui.GUI;
import com.tyldanny.javacalculator.panes.DisplayPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonClickListener implements ActionListener {
    private final GUI gui;
    private String text;

    public ButtonClickListener(GUI gui, String text) {
        this.gui = gui;
        this.text = text;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double val = Double.parseDouble(text);
            String result;
            if (gui.getCurrentValue() == 0) {
                result = val + "";
            } else {
                String temp = gui.getCurrentValue() + "";
                if (temp.contains(".")) {
                    temp = temp.split("\\.")[0] + text + "." + temp.split("\\.")[1];
                }
                result = temp;
            }

            gui.setCurrentValue(Double.parseDouble(result));

            setDisplay(result);
            return;
        } catch (NumberFormatException ignore) {}


        setDisplay(text);
    }

    private void setDisplay(String text) {
        gui.getDisplayPane().getField().setText(text);
    }
}
