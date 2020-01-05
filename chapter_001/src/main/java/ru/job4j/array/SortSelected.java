package ru.job4j.array;

/**
 * Сlass SortSelected
 * 6.5.3. Сортировка выборкой.
 * Внутри метода нужно создать цикл for для передвижения по элементам.
 * В этом задании мы будет использовать методы, которые уже реализовали в других задачах.
 * 1. MinDiapason.findMin - этот метод нужен для получения минимально элемента в массиве.
 * 2. FindLoop.indexOf(int[] data, int el, int start, int finish) - этот метод нужен чтобы получить индекс элемента полученного из метода MinDiapason.findMin.
 */

public class SortSelected {
    //data - массив чисел, который нужно отсортировать по возрастанию
    public static int[] sort(int[] data) {
        for (int start = 0; start < data.length - 1; start++) {
        int min = MinDiapason.findMin(data, start, data.length - 1);
        int index = FindLoop.indexOf(data, min, start, data.length - 1);
                if (data[index] != data[start]) {
                    int temp = data[index];
                    data[index] = data[start];
                    data[start] = temp;
                }
        }
        return data;
    }
}