package ru.job4j.sort;

import java.util.Arrays;

/**
 * Объединить два массива.
 * Даны два отсортированных массива.
 * Нужно написать метод, который берет элементы этих массивов и добавляет в третий массив в порядке возрастания.
 * Смысл решения сводиться к сравнению первых элементов массива.
 * Полученный элемент мы вставляем в третий массив.
 * Далее операция сравнения повторяется, но сравнение уже идет с первый элементов и нулевым.
 */

public class Merge {

    public int[] merge(int[] left, int[] right) {
        int[] rsl = new int[left.length + right.length];
        int i = 0;
        int j = 0;
        int y = 0;
        while (rsl.length > y) {
            if (i < left.length && j < right.length) {
                if (left[i] <= right[j]) {
                    rsl[y++] = left[i++];
                } else {
                    rsl[y++] = right[j++];
                }
            } else {
                if (i == left.length) {
                    rsl[y++] = right[j++];
                } else {
                    rsl[y++] = left[i++];
                }
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        Merge process = new Merge();
        int[] rsl = process.merge(
                new int[] {1, 3, 5},
                new int[] {2, 4}
        );
        System.out.println(Arrays.toString(rsl));
    }
}