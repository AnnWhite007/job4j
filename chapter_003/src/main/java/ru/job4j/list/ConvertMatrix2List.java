package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 4. Конвертация двумерного массива в ArrayList
 * необходимо реализовать обратную конвертацию двухмерного массива в одномерный список
 */

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        // Для прохода по двухмерному массиву нужно использовать вложенный цикл for-earch
        for (int[] row : array) {
            for (int cell : row) {
                list.add(cell);
            }
        }
        return list;
    }
}
