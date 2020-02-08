package ru.job4j.array;

/**
 * 6.0. Заполнить массив степенями чисел.
 * Необходимо создать программу, которая будет заполнять массив числами, возведенными в квадрат.
 */

public class Square {
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 0; i < rst.length; i++)
            rst [i] = (i + 1) * (i + 1); // заполнить массив через цикл элементами от 1 до bound возведенными в квадрат
        return rst;
    }
}