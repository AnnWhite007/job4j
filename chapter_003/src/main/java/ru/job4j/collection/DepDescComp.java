package ru.job4j.collection;

import java.util.Comparator;

/**
 * Нам нужно сравнить первые элементы по убыванию, если они равны,
 * то сравнить последующие элементы, но в возрастающем порядке.
 */

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] o1Spl = o1.split("/");
        String[] o2Spl = o2.split("/");
        if (o1Spl[0].equals(o2Spl[0])) {
            return o1.compareTo(o2);
        }
        return o2.compareTo(o1);
    }
}