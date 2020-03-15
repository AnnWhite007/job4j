package ru.job4j.array;

/**
 * 6.4. Слово начинается с ...
 * Нужно в цикле for c индексом сравнить значения ячеек с одинаковым индексом.
 */

public class ArrayChar {
    /**
     * Метод принимает два массива символов.
     * Метод проверяет, что слово начинается c определенной последовательности.
     */
    public static boolean startsWith(char[] word, char[] pref) {
        boolean result = true;
        for (int index = 0; index < pref.length; index++) {
            if (word[index] != pref[index]) {
                result = false;
                break;
            }
        }
        return result;
    }
}