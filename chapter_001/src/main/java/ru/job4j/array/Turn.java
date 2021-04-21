package ru.job4j.array;

/**
 * 6.2.3. Перевернуть массив.
 * Получить первый элемент, поменять с последним через временную переменную.
 * Проделать то же самое с элементами index -> array.length - index - 1
 */

public class Turn {

    /**
     * метод back, который принимает в себя массив целых чисел, а возвращает тот же самый массив, но перевёрнутый задом наперёд.
     */
    public int[] back(int[] array) {
        int j = array.length;
        for (int index = 0; index < array.length / 2; index++) {
            int temp = array[index];
            array[index] = array[j - 1];
            array[j - 1] = temp;
            j = j - 1;
        }
        return array;
    }
}
