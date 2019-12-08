package ru.job4j.array;

public class Turn {
    public int[] back(int[] array) {
        int j = array.length;
        for (int index = 0; index < array.length / 2; index++) {
            int temp = array [index];
            array [index] = array [j - 1];
            array [j - 1] = temp;
            j = j - 1;
        }
        return array;
    }
}
