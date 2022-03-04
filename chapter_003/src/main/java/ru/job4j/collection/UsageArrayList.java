package ru.job4j.collection;

import java.util.ArrayList;

/**
 * 0. Коллекции, ArrayList, List, Обобщения
 * Коллекции - это классы, позволяющие работать с наборами однотипных данных.
 * В Java основная структура для работы с наборами данных - это массив.
 * Все классы коллекций внутри используют либо массив, либо связанные списки.
 * Всего есть 4 базовых операции.
 *   - вставка данных names.add("");
 *   - замена данных names.set(0, "Ivan");
 *   - удаление данных names.remove(0);;
 *   - чтение данных через for-each
 *   Элемент языка - обобщение -  механизм позволяет в процессе компиляции проверить,
 *   что в коллекцию добавляют элементы только указанного типа.
 */

public class UsageArrayList {
    public static void main(String[] arg) {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Petr");
        names.add("Ivan");
        names.add("Stepan");
        for (Object value : names) {
            System.out.println(value);
        }
    }
}
