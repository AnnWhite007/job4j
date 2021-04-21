package ru.job4j.loop;

/**
 * 5.3. Построить шахматную доску в псевдографике.
 * Метод должен рисовать шахматную доску из символов x и пробелов.
 * Нарисуем доску с указанием индексов.
 * Для доски 3 на 3 вид:
 * i,j 0    1   2
 *  0  Х	 	Х
 *  1      Х
 *  2  Х	 	Х
 * Сумма индексов всегда четное число (число делится на 2 без остатка).
 */

public class Board {
    public static void paint(int width, int height) {
        for (int i = 1; i <= width; i++) {
            for (int j = 1; j <= height; j++) {
                // условие проверки, что писать пробел или X
                // Выше в задании мы определили закономерность, когда нужно проставлять X
                if ((i + j) % 2 == 0) {
                    System.out.print("X");
                } else {
                    System.out.print(" ");
                }
            }
            // добавляем перевод на новую строку.
            System.out.println();
        }
    }

    public static void main(String[] args) {
        paint(3, 3);
        System.out.println();
        paint(4, 4);
    }
}