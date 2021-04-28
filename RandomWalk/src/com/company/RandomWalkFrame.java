package com.company;

import javax.swing.*;

class RandomWalkFrame extends JFrame {

    RandomWalkFrame(){
        initUI();
    }

    private void initUI(){
        setTitle("Random Walk");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(new GUI());
        setSize(Screen.WIDTH,Screen.HEIGHT);
        setLocationRelativeTo(null);
    }
}
