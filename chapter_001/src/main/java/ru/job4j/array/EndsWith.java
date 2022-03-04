package ru.job4j.array;

/**
 * 6.4.1. Слово заканчивается с ...
 *
 */

public class EndsWith {
    /**
     * Метод проверяет, что слово заканчивается c определенной последовательности.
     * (проверить, что массив word имеет последние элементы одинаковые с post)
     */
    public static boolean endsWith(char[] word, char[] post) {
        boolean result = true;
        for (int i = 0; i < post.length; i++) {
            if (post[i] != word[word.length - post.length + i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}