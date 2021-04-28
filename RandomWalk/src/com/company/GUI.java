package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GUI extends JPanel {

    private static final int UP =1;
    private static final int DOWN =2;
    private static final int LEFT =3;
    private static final int RIGHT =4;
    private static final int STEPS =1000;
    private static final int STEP_SIZE =8;

    private int startX=getRandomIntInRange(0,Screen.WIDTH),startY=getRandomIntInRange(0,Screen.HEIGHT),endX,endY;
    private void doDrawing(Graphics g){
        for (int i = 0; i < STEPS; i++) {
            Graphics2D g2d=(Graphics2D) g;
            getRandomDirection();
            g2d.drawLine(startX, startY, endX, endY);
            startX=endX;
            startY=endY;
        }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent( g);
        doDrawing(g);
    }

    private int getRandomIntInRange(int min, int max){
        return new Random().nextInt((max - min) + 1) + min;
    }

    private void getRandomDirection(){
        int min=1,max=4;
        int result = getRandomIntInRange(min,max);
        switch (result){
            case UP:
                endX=startX;
                endY=startY+STEP_SIZE;
                break;
            case DOWN:
                endX=startX;
                endY=startY-STEP_SIZE;
                break;
            case LEFT:
                endX=startX-STEP_SIZE;
                endY=startY;
                break;
            case RIGHT:
                endX=startX+STEP_SIZE;
                endY=startY;
                break;
            default:
                endX=startX;
                endY=startY;
                break;
        }
    }
}
