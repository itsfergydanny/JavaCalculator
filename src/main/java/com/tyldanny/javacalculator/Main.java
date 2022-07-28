package com.tyldanny.javacalculator;

import com.tyldanny.javacalculator.gui.GUI;

public class Main {
    private static GUI gui;

    public static void main(String[] args) {
        gui = new GUI();
        javax.swing.SwingUtilities.invokeLater(() -> gui.createAndShowGUI());
    }
}