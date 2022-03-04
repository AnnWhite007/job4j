package ru.job4j.collection;

import java.util.List;

/**
 * 3. Конвертация ArrayList в двухмерный массив
 * нужно реализовать метод, который преобразует одномерный список в двухмерный массив.
 * В Java все пустые элементы массива заполняются значениями по умолчанию.
 * Метод ceil позволяет сделать округление в большую сторону
 * Принимает тип double, поэтому нам нужно делимое привести к типу double, чтобы результат деления был double
 * и приводим его к типу int после вычисления.
 */

public class ConvertList2Array {
    public static int[][] toArray(List<Integer> list, int cells) {
        int groups = (int) Math.ceil((double) list.size() / cells);
        int[][] array = new int[groups][cells];
        int row = 0, cell = 0;
        for (Integer num : list) {
            array[row][cell++] = num;
            if (cell == cells) {
                  cell = 0;
                  row++;
              }
        }
        return array;
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7);
        int[][] rsl = toArray(list, 3);
        for (int[] row : rsl) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
