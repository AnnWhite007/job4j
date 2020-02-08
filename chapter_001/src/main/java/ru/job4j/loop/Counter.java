package ru.job4j.loop;

/**
 * 5.1. Подсчет суммы чётных чисел в диапазоне
 * Вычислить сумму четныx чисел в диапазоне от start до finish
 */

public class Counter {
    public int add(int start, int finish) {
        int sum = 0;
        if (start % 2 == 0) {
            for (; start <= finish; start = start + 2)
                sum = sum + start;
        } else {
            for (start = start + 1; start <= finish; start = start + 2)
                sum = sum + start;
        }
        return sum;
    }
}