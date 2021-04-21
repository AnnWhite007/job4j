package ru.job4j.collection;

import java.util.HashSet;

/**
 * 2. Идентичные тексты
 * Нам нужно написать метод, который будет сравнивать два текста.
 * Если они состоят из один и тех же слов, то мы считаем, что текст не уникальный.
 * Метод contains - принимает элемент коллекции и возвращает true, если элемент уже есть или false, если его нет.
 */

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        // Преобразуем строку в массив слов.
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        // Массив строк вставить через цикл for-each в коллекцию HashSet
        for (String word : origin) {
            check.add(word);
        }
        for (String wordCheck : text) {
            if (!check.contains(wordCheck)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}