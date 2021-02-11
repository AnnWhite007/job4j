package ru.job4j.io;

import java.util.Scanner;

/**
 * 2. Scanner и чтение числа из консоли.
 * Игра 11. Смысл игры в следующем. На столе лежат 11 спичек.
 * Два игрока по очереди берут от 1 до 3 спичек.
 * Выигрывает тот, кто забрал последние спички.
 *
 * nextLine() - метод возвращает тип данных String.
 * Integer.valueOf. - преобразует в нужный тип данных, (parseInt())- метод преобразует String в int
 */
public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + " введите число от 1 до 3:");
            int matches = Integer.parseInt(input.nextLine());
            if (matches > 3) {
                System.out.println("Введенное число больше 3.");
            }
            else {
                turn = !turn;
                count = count - matches;
                System.out.println("Осталось " + count);
            }
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}
