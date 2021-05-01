package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 0. Stream API
 * Этот интерфейс позволяет гибко работать с коллекциями.
 * Stream API работает совместно с лямбда-выражениями.
 * Stream API - это поток данных.
 * Каждый элемент коллекции проходит 3 стадии.
 * 1. Фильтрация;
 * 2. Преобразование;
 * 3. Упрощение или аккумуляция.
 */

public class StreamUsage {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(5);
        list.add(-8);
        list.add(1);
        list.add(26);
        list.add(-1);
        List<Integer> filteredList = list.stream().filter(
                l -> l > 0
        ).collect(Collectors.toList());
        filteredList.forEach(System.out::println);
    }
}
