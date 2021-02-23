package ru.job4j.ex;

/**
 * 0. Что такое исключение.
 * Текст в конце начинающийся со строчек Exception in thread "main" указывает на то,
 * что в вашей программе  ошибка.
 * В программировании есть термин - программа завершилась с исключительной ситуацией
 * или в программе упал Exception.  Это значит, что в процессе выполнения программы
 * виртуальная машина не смогла выполнить инструкции написанные в вашей программе.
 * Исключение содержит описание причины его возникновения.
 * Вторая строчка сообщения в исключении указывает на операцию в программе,
 * которую виртуальная машина не смогла выполнить.
 */

import java.util.Arrays;

public class BackArray {
    public static void main(String[] args) {
        String[] names = {"Petr", "Ivan", "Nik", "Vasya"};
        int middle = names.length / 2;
        for (int index = 0; index < middle; index++) {
            String temp = names[index];
            names[index] = names[names.length - 1 - index];
            names[names.length - 1 - index] = temp;
        }
        System.out.println(Arrays.toString(names));
    }
}
