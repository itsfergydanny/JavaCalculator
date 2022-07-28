package com.tyldanny.javacalculator.gui;

import com.tyldanny.javacalculator.panes.DisplayPane;

import javax.swing.*;
import java.awt.*;

public class GUI {
    JFrame frame;
    int initialHeight;
    int initialWidth;

    public GUI() {}

    public void createAndShowGUI() {
        createBaseGUI();

        frame.add(new DisplayPane());
        frame.pack();

        displayWindow();
    }

    private void createBaseGUI() {
        frame = new JFrame("HelloWorld");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setInitialSizeAndPosition();
    }

    private void setInitialSizeAndPosition() {
        setSize();
        center();
    }

    private void setSize() {
        Dimension screenSize = getScreenSize();

        initialHeight = (int) (screenSize.height * 0.7);
        initialWidth = (int) (screenSize.height * 0.6);

        frame.setPreferredSize(new Dimension(initialWidth, initialHeight));
    }

    private void center() {
        Dimension screenSize = getScreenSize();
        int x = screenSize.width/2 - (initialWidth/2);
        int y = screenSize.height/2 - (initialHeight/2);
        frame.setLocation(x, y);
    }

    private void displayWindow() {
        frame.pack();
        frame.setVisible(true);
    }

    private Dimension getScreenSize() {
        return Toolkit.getDefaultToolkit().getScreenSize();
    }
}
