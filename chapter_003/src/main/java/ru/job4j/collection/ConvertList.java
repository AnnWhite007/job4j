package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * 5. Конвертация листа массивов в один лист Integer
 * Список может содержать любой объект.
 * Представим, что у нас есть список, содержащий массив чисел. Массив - это объект.
 * В этом задании Вам нужно будет преобразовать список с массивом чисел в список чисел.
 * Метод convert должен пройтись по всем элементам всех массивов в списке list и добавить их в список rsl
 */

public class ConvertList {
    public static List<Integer> convert(List<int[]> list) {
        List<Integer> rsl = new ArrayList<>();
        for (int[] row : list) {
            for (int cell : row) {
                rsl.add(cell);
            }
        }
        return rsl;
    }
}
