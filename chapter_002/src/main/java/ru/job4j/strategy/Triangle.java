package ru.job4j.strategy;

/**
 * Реализовать интерфейс Shape для  треугольника (Triangle)
 */

public class Triangle implements Shape {
    @Override
    public String draw() {
        String ln = System.lineSeparator();
        return "   ^    " + ln
                + " /   \\ " + ln
                + "/_____\\" + ln;
    }
    public static void main(String[] args) {
        System.out.println(new Triangle().draw());
    }
}
