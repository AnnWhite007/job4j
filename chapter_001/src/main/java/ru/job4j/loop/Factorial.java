package ru.job4j.loop;

/**
 * 5.2. Создать программу, вычисляющую факториал.
 * В качестве аргумента в метод приходит положительное целое число n,
 * сам метод должен возвращать рассчитанный факториал для этого числа.
 * Факториал для числа 5 будет равен 120 (1 * 2 * 3 * 4 * 5).
 * Факториал для числа 0 равен 1.
 * Факториал для числа 1 равен 1.
 */

public class Factorial {
    public int calc(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }
}