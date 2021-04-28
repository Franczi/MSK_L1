package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter("results.txt");

        double START_RANGE = 0.0;
        double END_RANGE = 1.0;
        double sumOfResults=0;
        int N = 10000;
        int[] SAMPLE_COUNT_ARR = {10000};
        for (int j = 0; j < N; j++) {
            for (int size : SAMPLE_COUNT_ARR) {
                double sumOfFields = 0.0;
                for (int i = 0; i < size; i++) {
                    double rand = getRandInRange(START_RANGE, END_RANGE);
                    double resultOfFunc = calculateValueOfArcSine(rand);
                    double field = calculateField(resultOfFunc, END_RANGE - START_RANGE);
                    sumOfFields += field;
                }
                System.out.println("Result for simples size: " + size + " =>" + (sumOfFields / size));
                appendIoFile((sumOfFields/size),writer);
                sumOfResults =sumOfFields/size;
            }
        }
        System.out.println("Mean of all results =>"+(sumOfResults/N));
        writer.close();
    }

    private static double calculateValueOfArcSine(double x) {
        return 1 / (Math.PI * Math.sqrt(x * (1.0 - x)));
    }

    private static double calculateField(double a, double b) {
        return a * b;
    }

    private static double getRandInRange(double min, double max) {
        return ((Math.random() * (max - min)) + min);
    }

    private static void appendIoFile(double result, FileWriter writer) {
        try {
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            writer.write(String.valueOf(decimalFormat.format(result))+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
