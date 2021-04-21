package ru.job4j.collection;

import java.util.Comparator;

/**
 * 3. Компаратор для строк
 * Необходимо реализовать поэлементное сравнение двух списков, т.е. сравниваем элементы двух списков,
 * находящихся на одних и тех же позициях (под одним и тем же индексом). Сравнение в лексикографическом порядке.
 * В этом задании нельзя использовать метод String.compareTo.
 *
 * При сравнении каждая строка раскладывается на массив символов,
 * которые в свою очередь преобразуются в массив чисел.
 * Дальше Java по очереди сравнивает каждую ячейку массива. Если вычисление дает результат 0,
 * то вычисление повторяется для следующей пары,
 * пока не дойдет до конца или пока результат не станет отличен от 0.
 */

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int size = Math.min(left.length(), right.length());
        for (int index = 0; index < size; index++) {
            if (left.charAt(index) != right.charAt(index)) {
                return  Character.compare(left.charAt(index), right.charAt(index));
            }
        }
        return Integer.compare(left.length(), right.length());
    }
}