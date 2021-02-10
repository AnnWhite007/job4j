package ru.job4j.tracker;

import java.util.Arrays;

/**
 * 5. Tracker - хранилище.
 * 6. Метод замены заявки. Tracker.replace
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
 * replace - метод замены заявки. То есть удалить заявку, которая уже есть в системе и добавить в эту ячейку новую.
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

    // получение заявки по id, возвращает объект Item
    public Item findById(int id) {
        // Находим индекс
        int index = indexOf(id);
        // Если индекс найден возвращаем item, иначе null
        return index != -1 ? items[index] : null;
    }

    // получение списка всех заявок
    public Item[] findAll() {
        Item []itemsWithoutNull = new Item[size];
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

    // Метод, который будет возвращать index по id
    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    // Замена заявки
    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
            items[index].setName(item.getName());
            return true;
        }
        else {
            return false;
        }
    }
}