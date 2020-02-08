package ru.job4j.converter;

/**
 * 3.2. Конвертер валюты.
 * Метод, который принимает числа (сколько денег нужно конвертировать в одной валюте)
 * и возвращает число (сколько денег получилось после конвертации)
 */

public class Converter {

    public static int rubleToEuro(int value) {
        return value / 70;
    }

    public static int rubleToDollar(int value) {
        return value / 60;
    }

    public static int euroToRuble(int value) {
        return value * 70;
    }

    public static int dollarToRuble(int value) {
        return value * 60;
    }

    public static void main(String[] args) {
        int euro = rubleToEuro(140);
        System.out.println("140 rubles are " + euro + " euro.");
        int dollars = rubleToDollar(180);
        System.out.println("180 rubles are " + dollars + " dollars.");
        int rubles = euroToRuble(10);
        System.out.println("10 euro are " + rubles + " rubles");
        rubles = dollarToRuble(10);
        System.out.println("10 dollars "+ rubles + " rubles");
    }
}
