package com.tyldanny.javacalculator.gui;

import com.tyldanny.javacalculator.grids.Grid;
import com.tyldanny.javacalculator.listeners.KeyboardListener;
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
    @Getter private int initialHeight;
    private int initialWidth;
    @Getter
    private DisplayPane historyPane;
    @Getter
    private DisplayPane displayPane;
    @Getter @Setter
    private OperationType previousOperationType = OperationType.NONE;
    @Getter
    private final Map<OperationType, Operation> OPERATIONS = new HashMap<>();

    public GUI() {
        OPERATIONS.put(OperationType.CLEAR, new ClearOperation(this, OperationType.CLEAR));
        OPERATIONS.put(OperationType.NEGATIVE_POSITIVE, new NegativePositiveOperation(this, OperationType.NEGATIVE_POSITIVE));
        OPERATIONS.put(OperationType.PERCENT, new PercentOperation(this, OperationType.PERCENT));
        OPERATIONS.put(OperationType.DIGIT, new DigitOperation(this, OperationType.DIGIT));
        OPERATIONS.put(OperationType.PERIOD, new PeriodOperation(this, OperationType.PERIOD));
        OPERATIONS.put(OperationType.ADDITION, new BasicOperation(this, OperationType.ADDITION));
        OPERATIONS.put(OperationType.EQUALS, new EqualsOperation(this, OperationType.EQUALS));
        OPERATIONS.put(OperationType.MULTIPLICATION, new BasicOperation(this, OperationType.MULTIPLICATION));
        OPERATIONS.put(OperationType.DIVISION, new BasicOperation(this, OperationType.DIVISION));
        OPERATIONS.put(OperationType.SUBTRACTION, new BasicOperation(this, OperationType.SUBTRACTION));
        OPERATIONS.put(OperationType.DEL, new DelOperation(this, OperationType.DEL));
    }

    public void createAndShowGUI() {
        createBaseGUI();

        Grid mainGrid = new Grid(7, 1, 0, 0, Color.WHITE);

        historyPane = new DisplayPane(Color.decode("#749CA7"));
        mainGrid.add(new Grid(1, 4, 0, 0, Color.WHITE, historyPane));

        displayPane = new DisplayPane(Color.decode("#E7F6F2"));
        mainGrid.add(new Grid(1, 4, 0, 0, Color.WHITE, displayPane));

        mainGrid.add(new Grid(1, 4, 0, 0, Color.WHITE,
                    new ButtonPane(this, "C"),
                    new ButtonPane(this, "DEL"),
                    new ButtonPane(this, "%"),
                    new ButtonPane(this, "/")
        ));

        mainGrid.add(new Grid(1, 4, 0, 0, Color.WHITE,
                new ButtonPane(this, "7"),
                new ButtonPane(this, "8"),
                new ButtonPane(this, "9"),
                new ButtonPane(this, "*")
        ));

        mainGrid.add(new Grid(1, 4, 0, 0, Color.WHITE,
                new ButtonPane(this, "4"),
                new ButtonPane(this, "5"),
                new ButtonPane(this, "6"),
                new ButtonPane(this, "-")
        ));

        mainGrid.add(new Grid(1, 4, 0, 0, Color.WHITE,
                new ButtonPane(this, "1"),
                new ButtonPane(this, "2"),
                new ButtonPane(this, "3"),
                new ButtonPane(this, "+")
        ));

        mainGrid.add(new Grid(1, 3, 0, 0, Color.WHITE,
                new ButtonPane(this, "+/-"),
                new ButtonPane(this, "0"),
                new ButtonPane(this, "."),
                new ButtonPane(this, "=")
        ));

        frame.add(mainGrid);
        frame.pack();

        displayWindow();
    }

    private void createBaseGUI() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        handleKeyboard();
        setInitialSizeAndPosition();
    }

    private void handleKeyboard() {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyboardListener(this));
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
