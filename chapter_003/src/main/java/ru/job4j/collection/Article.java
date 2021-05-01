package ru.job4j.collection;

import java.util.HashSet;

/**
 * Генератор текста
 * Задан большой текст. Из него вырезают слова и предложения. Из них составляют новый текст.
 * Нужно проверить, что новый текст был получен из оригинального.
 */

public class Article {
    public static boolean generateBy(String origin, String line) {

        String[] originArray = origin.split(" ");
        String[] lineArray = line.split(" ");
        HashSet<String> originSet = new HashSet<String>();
        for (String value : originArray) {
            if (value.contains(",")
                    || value.contains(":")
                    || value.contains(".")
                    || value.contains("!")) {
                originSet.add(value.substring(0, value.length() - 1));
            }
            originSet.add(value);
        }
        for (String value : lineArray) {
            if (!originSet.contains(value)) {
                return false;
            }
        }
        return true;
    }
}
