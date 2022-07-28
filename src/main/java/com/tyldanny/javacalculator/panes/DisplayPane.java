package com.tyldanny.javacalculator.panes;

import com.tyldanny.javacalculator.listeners.ButtonClickListener;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public class DisplayPane extends JPanel {
    private JTextField field;

    public DisplayPane() {
        field = new JTextField();
        field.setEditable(false);
        field.setText("0");
        field.setFont(field.getFont().deriveFont(100f));
        this.setLayout(new GridLayout(0, 1));
        this.add(field);
    }
}
