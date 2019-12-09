package ru.job4j.array;

public class BubbleSort {
    public int [] sort(int[] array) {
        for (int j = array.length; j > 0; j--) {
            for (int index = 0; index < array.length - 1; index++) {
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