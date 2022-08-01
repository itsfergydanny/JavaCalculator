package com.tyldanny.javacalculator.listeners;

import com.tyldanny.javacalculator.gui.GUI;
import com.tyldanny.javacalculator.operation.OperationType;
import lombok.AllArgsConstructor;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.UUID;

public class KeyboardListener implements KeyEventDispatcher {
    private final GUI gui;
    private long lastPressed = System.currentTimeMillis();

    public KeyboardListener(GUI gui) {
        this.gui = gui;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        if (lastPressed + 200 > System.currentTimeMillis()) {
            return true;
        }

        lastPressed = System.currentTimeMillis();

        String c = e.getKeyChar() + "";

        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            c = "=";
        } else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            c = "DEL";
        }

        OperationType type = OperationType.getFromText(c);
        if (type == OperationType.NONE) {
            return true;
        }

        gui.getOPERATIONS().get(type).handle(c);
        return true;
    }
}
