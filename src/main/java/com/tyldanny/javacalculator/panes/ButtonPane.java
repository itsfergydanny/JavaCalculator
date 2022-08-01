package com.tyldanny.javacalculator.panes;

import com.tyldanny.javacalculator.gui.GUI;
import com.tyldanny.javacalculator.listeners.ButtonClickListener;

import javax.swing.*;
import java.awt.*;

public class ButtonPane extends JPanel {
    public ButtonPane(GUI gui, String text) {
        JButton button = new JButton(text);
        button.addActionListener(new ButtonClickListener(gui, text));
        button.setForeground(Color.decode("#E7F6F2"));
        button.setBackground(Color.decode("#395B64"));
        button.setBorder(BorderFactory.createLineBorder(Color.decode("#E7F6F2"), 1));
        button.setFont(button.getFont().deriveFont(gui.getInitialHeight() * 0.035f));
        this.setLayout(new GridLayout(0, 1));
        this.add(button);
    }
}
