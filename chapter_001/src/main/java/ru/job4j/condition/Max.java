package ru.job4j.condition;

/**
 * 4.2. Максимум из двух чисел.
 * Сравнить два числа и получить вернуть максимальное из них.
 */

public class Max {
    public static int max(int left, int right) {
        int result = left > right ? left : right;
        return result;
    }
}
