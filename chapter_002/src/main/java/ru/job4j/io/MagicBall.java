package ru.job4j.io;

import java.util.Scanner;
import java.util.Random;

/**
 * 1. Чтение из консоли. Класс java.util.Scanner.
 * Реализуем предсказателя. Пользователь вводит вопрос, программа генерирует случайное число
 * и выводит ответ на вопрос пользователя: да, нет, может быть.
 * Используем объект класса Scanner для ввода данных в нашу программу с клавиатуры
 * Он принимает в качестве параметра объект "System.in"
 * У объекта Scanner есть метод nextLine(), который считывает все символы строки после нажатия на клавишу Enter.
 * Через класс Random сгенерируем число от 0-3.
 */

public class MagicBall {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        String name = input.nextLine();
        System.out.println();
        int answer = new Random().nextInt(3);
        if (answer == 0) {
            System.out.println("Да");
        } else if (answer == 1) {
            System.out.println("Нет");
        } else {
            System.out.println("Может быть");
        }
    }
}
