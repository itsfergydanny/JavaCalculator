package com.tyldanny.javacalculator.grids;

import javax.swing.*;
import java.awt.*;

public class Grid extends JPanel {
    public Grid(int rows, int cols, int hgap, int vgap, Color backgroundColor, JPanel... items) {
        this.setLayout(new GridLayout(rows, cols, hgap, vgap));
        this.setVisible(true);
        this.setBackground(backgroundColor);

        for (JPanel item : items) {
            this.add(item);
        }
    }
}
