package ru.job4j.array;

/**
 * 6.4.1. Слово заканчивается с ...
 *
 */

public class EndsWith {
    /**
     * Метод проверяет, что слово заканчивается c определенной последовательности.
     */
    public static boolean endsWith(char[] word, char[] post) {
        boolean result = true;
        // проверить. что массив word имеет последние элементы одинаковые с post
        for (int i = 0; i < post.length; i++) {
            if (post[i] != word[word.length - post.length + i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}