package ru.job4j.condition;

/**
 * 4.3. Вычисление площади треугольника.
 * Нужно проверить, что треугольник может существовать.
 * треугольник может существовать, если сумму двух сторон больше третьей для всех комбинаций.
 * Допустим у нас заданы три переменные
 * double ab, ac, dc - это длины сторон.
 */

public class Triangle {

    public static boolean exist(double ab, double ac, double bc) {
        if (ab + ac > bc && ac + bc > ab && ab + bc > ac) {
            return true;
        } else {
            return false;
        }
    }
}