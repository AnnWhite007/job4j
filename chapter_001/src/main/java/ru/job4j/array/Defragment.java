package ru.job4j.array;

/**
 * Class Defragment
 * 6.8. Удаление дубликатов в массиве.
 * Написать код, который будет перемещать заполненные ячейки массива в начало, а пустые в конец.
 */

public class Defragment {
    public static String[] compress(String[] array) {
        for (int index = 0; index < array.length - 1; index++) {
            String cell = array[index];
            int j = index;
            if (cell == null) {
                while (j < array.length - 1) {
                    String temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    j++;
                }
            }
            System.out.print(array[index] + " ");
        }
        return array;
    }

    public static void main(String[] args) {
        String[] input = {"I", null, "wanna", null, "be", null, "compressed"};
        String[] compressed = compress(input);
        System.out.println();
        for (int index = 0; index < compressed.length; index++) {
            System.out.print(compressed[index] + " ");
        }
    }
}