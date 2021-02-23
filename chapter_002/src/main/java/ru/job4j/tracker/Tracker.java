package ru.job4j.tracker;

import java.util.Arrays;

/**
 * 5. Tracker - хранилище.
 * 6. Метод замены заявки. Tracker.replace
 * 7. Метод удаления заявки Tracker.delete
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
 * replace - метод замены заявки. То есть удалить заявку,
 * которая уже есть в системе и добавить в эту ячейку новую.
 * delete - метод удаления заявки (запись в ячейку нулевой ссылки - null),
 * c перемещением всех ячеек справа на одну позицию с помощью метода
 * System.arraycopy(source, startPos, dist, distPos, length);
 * source - массив откуда нужно скопировать элементы начиная с позиции startPos и до позиции startPos + length.
 * length - сколько элементов взять начиная от startPos.
 * dist - массив, куда вставить скопированные элементы от source.
 * Этот метод может работать с одним массивом для source и dist.
 * distPos - начиная с какого элемента вставлять скопированные ячейки.
 *
 *  8. Что такое валидация?
 * - это проверка параметров метода. Если параметры не верные, то выполнить метод нельзя.
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
        return Arrays.copyOf(items, size);
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

    // Замена заявки + валидация
    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            items[index] = item;
        }
        return rsl;
    }
    // Удаление элемента из массива и перемещение всех ячеек справа на одну позицию + валидация
    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            System.arraycopy(items, index + 1, items, index, size - index - 1);
            items[size - 1] = null;
            size--;
        }
        return rsl;
    }
}