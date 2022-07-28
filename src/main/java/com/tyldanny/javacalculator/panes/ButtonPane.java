package com.tyldanny.javacalculator.panes;

import com.tyldanny.javacalculator.gui.GUI;
import com.tyldanny.javacalculator.listeners.ButtonClickListener;

import javax.swing.*;
import java.awt.*;

public class ButtonPane extends JPanel {
    public ButtonPane(GUI gui, String text) {
        JButton button = new JButton(text);
        button.addActionListener(new ButtonClickListener(gui.getDisplayPane(), text));
        this.setLayout(new GridLayout(0, 1));
        this.add(button);
    }
}
