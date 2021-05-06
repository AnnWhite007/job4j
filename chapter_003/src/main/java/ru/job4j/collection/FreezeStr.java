package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * 2. Проверить две строчки на идентичность.
 * Даны две строки. Нужно проверить,
 * что вторая строка получилась методом перестановок символов в первой строке.
 */

public class FreezeStr {
    public static boolean eq(String left, String right) {
        char[] leftArray = left.toCharArray();
        char[] rightArray = right.toCharArray();
        Map<Character, Integer> lmap = new HashMap<Character, Integer>();
        for (char value : leftArray) {
            if (lmap.keySet().contains(value)) {
                lmap.put(value, lmap.get(value) + 1);
            }
            lmap.put(value, 1);
        }

        for (char value : rightArray) {
            if (!lmap.containsKey(value)) {
                return false;
            } else if (lmap.get(value) == 1) {
                lmap.remove(value);
            } else if (lmap.get(value) > 1) {
                lmap.put(value, lmap.get(value) - 1);
            }
        }

        if (lmap.isEmpty()) {
            return true;
        }
        return false;
    }
}