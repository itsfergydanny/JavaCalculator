package com.tyldanny.javacalculator.panes;

import javax.swing.*;
import java.awt.*;

public class DisplayPane extends JPanel {
    public DisplayPane() {
        addTextField();
    }

    private void addTextField() {
        JTextField field = new JTextField();
        field.setEditable(false);

        field.setText("0");
this.setLayout(new GridLayout(0, 1));
        this.add(field);
    }

//    @Override
//    public void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        Graphics2D g2d = (Graphics2D) g.create();
//        int size = Math.min(getWidth() - 4, getHeight() - 4) / 10;
//        int width = getWidth() - (size * 2);
//        int height = getHeight() - (size * 2);
//
//        int y = (getHeight() - (size * 10)) / 2;
//        for (int horz = 0; horz < 10; horz++) {
//            int x = (getWidth() - (size * 10)) / 2;
//            for (int vert = 0; vert < 10; vert++) {
//                g.drawRect(x, y, size, size);
//                x += size;
//            }
//            y += size;
//        }
//        g2d.dispose();
//    }
}
