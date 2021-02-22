package ru.job4j.strategy;

/**
 * Реализовать интерфейс Shape для квадрата (Square)
 */

public class Square implements Shape {

    @Override
    public String draw() {
        String ln = System.lineSeparator();
        return    "   _______   " + ln
                + "  |       |  " + ln
                + "  |       |  " + ln
                + "   -------   " + ln;
    }
    public static void main(String[] args) {
        System.out.println(new Square().draw());
    }
}
