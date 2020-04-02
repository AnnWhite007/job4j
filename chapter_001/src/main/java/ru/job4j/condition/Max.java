package ru.job4j.condition;

/**
 * 4.2. Максимум из двух чисел.
 * Сравнить два числа и получить вернуть максимальное из них.
 *
 * 3. Перегрузить метод max для трех чисел.
 * В Java есть механизм позволяющий создавать методы со одинаковыми именами,
 * но с разными входными параметрами.
 */

public class Max {
    public static int max(int left, int right) {
        int result = left > right ? left : right;
        return result;
    }
    public static int max(int left, int right, int front) {
        int result = max(left, right) > front ? max(left, right) : front;
        return result;
    }

}
