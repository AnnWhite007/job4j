package ru.job4j.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * 3. Ссылки на методы
 * Метод forEach принимает объект Consumer, который описан через лямбда.
 * Интерфейс java.function.Consumer имеет абстрактный метод.
 * "void accept(String t);"
 * Лямбда вызывает метод.
 * Отличие этих методов только в имени.
 * Если вся лямбда - это вызов другого метода, то такой код можно упростить.
 * С помощью двойного двоеточия (::), а не через точку (.)
 */

public class RefMethod {
    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "Ivan",
                "Petr Arsentev"
        );
       Consumer<String> out = RefMethod::cutOut;
       names.forEach(out);
    }

    public static void cutOut(String value) {
        if (value.length() > 10) {
            System.out.println(value.substring(0, 10) + "..");
        } else {
            System.out.println(value);
        }
    }
}