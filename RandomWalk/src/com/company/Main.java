package com.company;

import javax.swing.*;

class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RandomWalkFrame frame = new RandomWalkFrame();
            frame.setVisible(true);
        });
    }
}