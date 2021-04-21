package ru.job4j.array;

/**
 * Class FindLoop
 * 6.1. Классический поиск перебором.
 * У нас задан массив элементов. Нам необходимо найти индекс элемента, удовлетворяющего условию.
 * Решение этой задачи сводится в последовательному перебору каждого элемента.
 * Если элемент подходит под условие, мы останавливаем цикл и возвращаем индекс нашего элемента.
 * 6.5. Поиск индекса в диапазоне.
 * Нужно усовершенствовать классический поиск.
 * Теперь нужно сделать поиск по массиву, но не во всем массиве, а только в указанном диапазоне.
 */

public class FindLoop {
    public static int indexOf(int[] data, int el) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    /**
     * @param data - массив чисел
     * @param el - элемент, который нужно найти
     * @param start - индекс с которого начинаем поиск
     * @param finish - индекс которым заканчиваем поиск
     * @return - если элемента нет в массиве, то возвращаем -1
     */
    public static int indexOf(int[] data, int el, int start, int finish) {
        int rst = -1;
        for (int index = start; index < finish; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
            return rst;
    }
}
