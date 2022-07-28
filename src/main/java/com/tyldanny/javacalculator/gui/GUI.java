package com.tyldanny.javacalculator.gui;

import com.tyldanny.javacalculator.grids.Grid;
import com.tyldanny.javacalculator.panes.ButtonPane;
import com.tyldanny.javacalculator.panes.DisplayPane;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class GUI {
    JFrame frame;
    int initialHeight;
    int initialWidth;

    public GUI() {}

    public void createAndShowGUI() {
        createBaseGUI();

        Grid mainGrid = new Grid(6, 1, 0, 0, Color.decode("#4D8BFF"));

        mainGrid.add(new Grid(1, 4, 0, 0, Color.red, new DisplayPane()));

        mainGrid.add(new Grid(1, 4, 0, 0, Color.red,
                    new ButtonPane("C"),
                    new ButtonPane("+/-"),
                    new ButtonPane("%"),
                    new ButtonPane("/")
        ));

        mainGrid.add(new Grid(1, 4, 0, 0, Color.red,
                new ButtonPane("7"),
                new ButtonPane("8"),
                new ButtonPane("9"),
                new ButtonPane("X")
        ));

        mainGrid.add(new Grid(1, 4, 0, 0, Color.red,
                new ButtonPane("4"),
                new ButtonPane("5"),
                new ButtonPane("6"),
                new ButtonPane("-")
        ));

        mainGrid.add(new Grid(1, 4, 0, 0, Color.red,
                new ButtonPane("1"),
                new ButtonPane("2"),
                new ButtonPane("3"),
                new ButtonPane("+")
        ));

        mainGrid.add(new Grid(1, 3, 0, 0, Color.red,
                new ButtonPane("0"),
                new ButtonPane("."),
                new ButtonPane("=")
        ));

        frame.add(mainGrid);
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
