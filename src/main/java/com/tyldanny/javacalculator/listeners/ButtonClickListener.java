package com.tyldanny.javacalculator.listeners;

import com.tyldanny.javacalculator.events.ButtonClickEvent;
import com.tyldanny.javacalculator.panes.DisplayPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonClickListener implements ActionListener {
    private final DisplayPane displayPane;
    private final String text;

    public ButtonClickListener(DisplayPane displayPane, String text) {
        this.displayPane = displayPane;
        this.text = text;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setDisplay(text);
    }

    private void setDisplay(String text) {
        this.displayPane.getField().setText(text);
    }
}
