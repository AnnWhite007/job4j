package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;

/**
 * 1. Уникальные задачи.
 * Имеется система поиска задач по тексту. Система возвращает нам список задач.
 * Некоторые задачи могут повторяться несколько раз.
 *  Метод extractNumber извлечет все номера и уберет дубликаты.
 *  Коллекции Set хранят только уникальные элементы.
 *  Между собой элементы сравниваются в HashSet через метод equals.
 */

public class FullSearch {
    public static HashSet<String> extractNumber(List<Task> list) {
        HashSet<String> numbers = new HashSet<>();
        for (Task value : list) {
            numbers.add(value.getNumber());
        }
        return numbers;
    }
}