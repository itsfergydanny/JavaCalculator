package com.tyldanny.javacalculator.gui;

import com.tyldanny.javacalculator.grids.Grid;
import com.tyldanny.javacalculator.operation.*;
import com.tyldanny.javacalculator.panes.ButtonPane;
import com.tyldanny.javacalculator.panes.DisplayPane;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class GUI {
    private JFrame frame;
    private int initialHeight;
    private int initialWidth;
    @Getter
    private DisplayPane historyPane;
    @Getter
    private DisplayPane displayPane;
    @Getter @Setter
    private Double previousValue = null;
    @Getter @Setter
    private double currentValue = 0;
    @Getter @Setter
    private OperationType previousOperationType = OperationType.NONE;
    @Getter
    private final Map<OperationType, IOperation> OPERATIONS = new HashMap<>();
    private boolean hasPeriod = false;

    public GUI() {
        OPERATIONS.put(OperationType.CLEAR, new ClearOperation(this));
        OPERATIONS.put(OperationType.NEGATIVE_POSITIVE, new NegativePositiveOperation(this));
        OPERATIONS.put(OperationType.PERCENT, new PercentOperation(this));
        OPERATIONS.put(OperationType.DIGIT, new DigitOperation(this));
        OPERATIONS.put(OperationType.PERIOD, new PeriodOperation(this));
        OPERATIONS.put(OperationType.ADDITION, new AdditionOperation(this));
        OPERATIONS.put(OperationType.EQUALS, new EqualsOperation(this));
    }

    public void createAndShowGUI() {
        createBaseGUI();

        Grid mainGrid = new Grid(7, 1, 0, 0, Color.decode("#4D8BFF"));

        historyPane = new DisplayPane();
        mainGrid.add(new Grid(1, 4, 0, 0, Color.red, historyPane));

        displayPane = new DisplayPane();
        mainGrid.add(new Grid(1, 4, 0, 0, Color.red, displayPane));

        mainGrid.add(new Grid(1, 4, 0, 0, Color.red,
                    new ButtonPane(this, "C"),
                    new ButtonPane(this, "+/-"),
                    new ButtonPane(this, "%"),
                    new ButtonPane(this, "/")
        ));

        mainGrid.add(new Grid(1, 4, 0, 0, Color.red,
                new ButtonPane(this, "7"),
                new ButtonPane(this, "8"),
                new ButtonPane(this, "9"),
                new ButtonPane(this, "X")
        ));

        mainGrid.add(new Grid(1, 4, 0, 0, Color.red,
                new ButtonPane(this, "4"),
                new ButtonPane(this, "5"),
                new ButtonPane(this, "6"),
                new ButtonPane(this, "-")
        ));

        mainGrid.add(new Grid(1, 4, 0, 0, Color.red,
                new ButtonPane(this, "1"),
                new ButtonPane(this, "2"),
                new ButtonPane(this, "3"),
                new ButtonPane(this, "+")
        ));

        mainGrid.add(new Grid(1, 3, 0, 0, Color.red,
                new ButtonPane(this, "0"),
                new ButtonPane(this, "0"),
                new ButtonPane(this, "."),
                new ButtonPane(this, "=")
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

    public boolean hasPeriod() {
        return hasPeriod;
    }

    public void setHasPeriod(boolean hasPeriod) {
        this.hasPeriod = hasPeriod;
    }
}
