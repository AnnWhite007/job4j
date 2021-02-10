package ru.job4j.tracker;

import java.util.Arrays;

/**
 * 5. Tracker - хранилище.
 * Метод public Item add(Item item) добавляет заявку,
 * переданную в аргументах в массив заявок items.
 * Метод public Item findById(int id) проверяет в цикле все элементы массива items,
 * равнивая id с аргументом int id
 * и возвращает найденный Item. Если Item не найден - возвращает null.
 * Метод public Item[] findAll() возвращает копию массива
 * items без null элементов (без пустых ячеек)
 * Метод public Item[] findByName(String key) проверяет в цикле все элементы массива items,
 * сравнивая name (используя метод getName класса Item) с аргументом метода String key.
 * Элементы, у которых совпадает name, копирует в результирующий массив и возвращает его.
 * Алгоритм этого метода аналогичен методу findAll.
 */

public class Tracker {
     // Массив для хранения заявок, содержит возможное количество заявлений
    private final Item[] items = new Item[100];
    // Поле для генерации нового ключа, представляет собой последовательность
    private  int ids = 1;
    // Размер нового массива
    private int size = 0;

    // добавление заявок
    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }
    // получение заявки по id
    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
        // получение списка всех заявок
    public Item[] findAll() {
        Item [] itemsWithoutNull = new Item[size];
        int resize = 0;
        for (int i = 0; i < size; i++) {
            Item item = items[i];
            if (item != null) {
                itemsWithoutNull[resize] = item;
                resize++;
            }
        }
        return Arrays.copyOf(itemsWithoutNull, resize);
    }

    // получение списка по имени
    public Item[] findByName(String key) {
        Item[] sameName = new Item[size];
        int resize = 0;
        for (int index = 0; index < size; index++) {
            Item name = this.items[index];
            if (name.getName().equals(key)) {
                sameName[resize] = name;
                resize++;
            }
        }
        sameName = Arrays.copyOf(sameName, resize);
        return sameName;
    }
}