package ru.job4j.collection;

import java.util.*;

/**
 * 2. Отсортировать департаменты [#371326]
 * Коды подразделений представлены в виде массива строк вида:
 * , где каждая строка имеет следующую структуру: код текущего подразделения,
 * а перед ним коды всех более крупных подразделений (к примеру департамент K1 включает в себя службу SK1, включающую в себя отдел SSK1).
 * Подразделения в одной строке разделены знаком "/".
 * Возможны случаи, когда в массиве отсутствуют строки с кодом вышестоящего подразделения,
 * в таком случае необходимо добавить строку с кодом данного подразделения и учитывать ее при сортировке.
 *
 * Необходимо разработать класс, который будет добавлять пропущенные подразделения,
 * а также производить сортировку подразделений по возрастанию и убыванию, при которых сохранялась бы иерархическая структура.
 * Промежуточная коллекция LinkedHashSet позволяет устранить дубликаты из коллекции,
 * которые будут получаться в результате последовательного складывания единичных департаментов.
 * Нужно определить, какие элементы отсутствуют в системе. Для этого каждую входящую строку нужно разбить на одиночные элементы.
 */

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                tmp.add(start + el);
                start = start + el + "/";
            }
        }
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> orgs) {
        sortAsc(orgs);
        Collections.sort(orgs, new DepDescComp());
    }
}