package ru.job4j.array;

/**
 * Class Min
 * 6.5.1. Поиск минимального числа в массиве.
 * Последовательно сравниваем первую переменную с каждым элементом в массиве.
 * Если элемент в массиве меньше, чем наша переменная, то в переменную мы записываем этот элемент.
 */

public class Min {
    public static int findMin(int[] array) {
        int min = array[0];
        for (int index = 0; index < array.length; index++) {
            // проверить, что эталон больше, чем элемент. записать в эталон элемент массива.
            if (min > array[index]){
                min = array[index];
            }
        }
        return min;
    }
}
