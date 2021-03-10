package ru.job4j.ex;

/**
 * 3. Замена if-else-throw на if-throw
 * По сути оператор if-else связывает исключение и полезный код.
 * Такую конструкцию всегда стоит разбивать на две части.
 * Это блок if-throw и полезную часть.
 */

public class Find {
    public static String get(String[] data, int index) {
        if (index < 0 && index >= data.length) {
            throw new IllegalArgumentException("Index out of bound");
        }
        return data[index];
    }

    public static void main(String[] args) {
        String[] data = {"one", "two", "three"};
        String rsl = Find.get(data, 1);
        System.out.println(rsl);
    }
}
