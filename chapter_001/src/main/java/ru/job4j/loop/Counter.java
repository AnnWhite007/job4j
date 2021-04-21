package ru.job4j.loop;

/**
 * 5.1. Подсчет суммы чётных чисел в диапазоне
 * Вычислить сумму четныx чисел в диапазоне от start до finish
 */

public class Counter {
    public int add(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}