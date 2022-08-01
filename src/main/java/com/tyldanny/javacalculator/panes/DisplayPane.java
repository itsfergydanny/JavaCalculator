package com.tyldanny.javacalculator.panes;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public class DisplayPane extends JPanel {
    private final JTextField field;

    public DisplayPane(Color color) {
        field = new JTextField();
        field.setEditable(false);
        field.setText("0");
        field.setFont(field.getFont().deriveFont(100f));
        field.setForeground(color);
        this.setLayout(new GridLayout(0, 1));
        this.add(field);
    }
}
