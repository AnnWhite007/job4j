package ru.job4j.collection;

import java.util.Comparator;

/**
 * 4. Сортировка номера
 * Система использует сортировку по алфавиту, а не по номеру.
 * Из-за этого номер задания приходится делать составным (с точкой).
 *
 * Ваша задача дописать компаратор, чтобы он сравнивал начальный номер.
 */

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int leftInt = Integer.parseInt(left.split(". ")[0]);
        int rightInt = Integer.parseInt(right.split(". ")[0]);
        return Integer.compare(leftInt, rightInt);
    }
}