package ru.job4j.collection;

import java.util.HashMap;
import java.util.List;

/**
 * 2. Преобразования List в Map.
 * В систему поступает список заказов.
 * Нам было бы удобно работать с ним по номеру. Для этого нужно преобразовать список заявок в карту.
 * В качестве ключа установить поле number.
 * Внутри метода process нужно пройти по всем элементам списка orders и вставить их в map.
 */

public class OrderConvert {

    public static HashMap<String, Order> process(List<Order> orders) {
        HashMap<String, Order> map = new HashMap<>();
        for (Order value : orders) {
                map.put(value.getNumber(), value);
        }
        return map;
    }
}