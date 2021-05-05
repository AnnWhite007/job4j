package ru.job4j.collection;


import java.util.Arrays;
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
        Arrays.sort(leftArray);
        Arrays.sort(rightArray);
        Map<Integer, Character> lmap = new HashMap<Integer, Character>();
        Map<Integer, Character> rmap = new HashMap<Integer, Character>();
        int il = 1;
        int ir = 1;
        for (char value : leftArray) {
            lmap.put(il, value);
            il++;
        }
        for (char value : rightArray) {
            rmap.put(ir, value);
            ir++;
        }

        for (int key : lmap.keySet()) {
            if (rmap.get(key) != lmap.get(key)) {
                return false;
            }
        }
        return true;
    }
}