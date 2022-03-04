package ru.job4j.pojo;

/**
 * 3.1. Массив с пустыми ячейками
 * Если мы попробуем получить данные из пустых ячеек, то мы получим null-ссылку. Это значение не существующего объекта.
 * У значения null нельзя вызывать методы объекта. Это приведет к ошибке NullPointerException.
 * Поэтому, если в коде есть ситуация, что переменная может содержать значение null,
 * а нам нужно с ней работать, то нужно перед выполнением операции проверить, что объект не равен null.
 */

public class Shop {

    public static int indexOfNull(Product[] products) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                return i;
            }
        }
        return -1;
    }
}

