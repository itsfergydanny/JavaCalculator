package com.tyldanny.javacalculator.panes;

import javax.swing.*;
import java.awt.*;

public class ButtonPane extends JPanel {
    public ButtonPane(String text) {
        JButton button = new JButton(text);
        this.setLayout(new GridLayout(0, 1));
        this.add(button);
    }
}
