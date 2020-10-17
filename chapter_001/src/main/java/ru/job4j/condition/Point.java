package ru.job4j.condition;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

/**
 * 3.4. Расстояние между точками в системе координат
 * Метод должен вычислить расстояние методу точками в системе координат.
 *
 * 2: 1. Рефакторинг - Расстояние между точками.
 * Задача переписать код в ООП стиле.
 * Это значит, что нам нужно уйти от прямой работы с примитивными типами
 * и начать использовать объекты.
 * Цельным объектом здесь будет точка в системе координат.
 */
/*
public class Point {
    public static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static void main(String[] args) {
        double result = distance(0, 0, 2, 0);
        System.out.println("result (0, 0) to (2, 0) " + result);
        result = distance(4, 0, 4, 3);
        System.out.println("result (4, 0) to (4, 3) " + result);
    }
}
*/

public class Point {

    private int x;
    private int y;
    private int z;

    public Point(int first, int second) {
        this.x = first;
        this.y = second;
    }

    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double distance(Point that) {
        return sqrt(pow(this.x - that.x, 2) + pow(this.y - that.y, 2));
    }

    public double distance3d(Point that) {
        return (sqrt(pow(this.x - that.x, 2) + pow(this.y - that.y, 2) + pow(this.z - that.z, 2)));
    }

    public static void main(String[] args) {
        Point a = new Point(0, 0, 0);
        Point b = new Point(0, 0, 2);
        double dist = a.distance3d(b);
        System.out.println(dist);
    }
}