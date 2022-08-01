package com.tyldanny.javacalculator.events;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

@AllArgsConstructor
public class ButtonClickEvent implements Action {
    private final String message;

    @Override
    public Object getValue(String key) {
        return null;
    }

    @Override
    public void putValue(String key, Object value) {}

    @Override
    public void setEnabled(boolean b) {}

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {}

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {}

    @Override
    public void actionPerformed(ActionEvent e) {}
}
