package ru.job4j.array;

public class BubbleSort {
    public int [] sort(int[] array) {
        for (int j = 1; j < array.length; j++) {
            for (int index = 0; index < array.length - j; index++) {
                if (array[index] > array[index + 1]) {
                    int temp = array[index];
                    array[index] = array[index + 1];
                    array[index + 1] = temp;
                }
            }
        }
    return array;
    }
}