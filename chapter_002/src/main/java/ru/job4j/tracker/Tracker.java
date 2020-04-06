package ru.job4j.tracker;

import java.util.Random;
import java.util.Arrays;

public class Tracker {
    /**
     * Массив для хранения заявок.
     */
    private final Item[] items = new Item[100];
    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод добавления заявки в хранилище
     *
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(generateId());
        items[position++] = item;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     *
     * @return Уникальный ключ.
     */
    private String generateId() {
        //Реализовать метод генерации
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }

    //получение списка всех заявок
    // Метод public Item[] findAll() возвращает копию массива this.items
// без null элементов (без пустых клеток).
    public Item[] findAll(String[] args) {
        Item[] withoutNull = new Item[this.items.length];
        int size = 0;
        for (int index = 0; index < this.items.length; index++) {
            Item name = this.items[index];
            if (name != null) {
                withoutNull[size] = name;
                size++;
            }
        }
        withoutNull = Arrays.copyOf(withoutNull, size);
        return withoutNull;
    }

    //получение списка по имени
    public Item[] findByName(String key) {
        Item[] sameName = new Item[this.items.length];
        int size = 0;
        for (int index = 0; index < this.items.length; index++) {
            Item name = this.items[index];
            if (name.equals(key)) {
                sameName[size] = name;
                size++;
            }
        }
        sameName = Arrays.copyOf(sameName, size);
        return sameName;
    }

    //получение заявки по id
    public Item findById(String id) {
        for (int index = 0; index < this.items.length; index++) {
            if (this.items[index].equals(id)) {
                return this.items[index];
            }
        }
        return null;
    }
}