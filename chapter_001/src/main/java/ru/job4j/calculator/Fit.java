package ru.job4j.calculator;

/**
 * 3.3. Идеальный вес.
 * Реализуем программу для вычисления идеального веса
 */

public class Fit {

    public static double manWeight(double height) {
        return (height - 100) * 1.15;
    }


    public static double womanWeight(double height) {
        return (height - 110) * 1.15;
    }

    public static void main(String[] args) {
        double man = manWeight(185);
        double woman = womanWeight(170);
        System.out.println("Man 185 is " + man);
        System.out.println("Woman 170 is " + woman);
    }

}