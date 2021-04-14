package ru.job4j.collection;

import java.util.HashMap;

/**
 * 0. Map, HashMap
 * java.util.Map - интерфейс описывающий колекции, которые используют ассоциативные карты или справочники (ключ-значение).
 * Интерфейс java.util.Map имеет два базовых метода
 * void put(K key, V value); // вставит данные в карту, делаем ассоциацию ключа с его значением.
 * V get(K key); // получить значение по ключу.
 * В интерфейсе java.util.Map есть методы keySet(), который возвращает коллекцию java.util.Set состоящую только из ключей.
 * Через метод get мы получаем значение ассоциированное с этим ключом.
 * Метод entrySet() - вернет коллекцию java.util.Set состоящую из объекта Map.Entry, которая сразу содержит и ключ и значение.
 * Ключ пары должен быть уникальный. Если в Map уже есть такой key, то ячейка value будет заменена на новое значение.
 * Удаление происходит по ключу через метод remove(key)
 */

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        //Вставить данные в карту можно используя метод put
        map.put("google@gmail.com", "Ivanov Ivan Ivanovich");
        map.put("sidorov@gmail.com", "Sidorov Ivan Ivanovich");
        map.put("google@gmail.com", "Petrov Petr Petrovich");
        // Ключ пары должен быть уникальный. Если в Map уже есть такой key, то ячейка value будет заменена на новое значение
        map.put("fedorov@gmail.com", "Fedorov Fedor Fedorovich");

        //Удаление происходит по ключу через метод remove(key)
        map.remove("fedorov@gmail.com");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " - " + value);
        }
    }
}
