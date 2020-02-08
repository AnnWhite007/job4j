package ru.job4j.loop;

import java.util.function.BiPredicate;

/**
 * @author Anna Babintseva
 * @version $2.0$
 * @since 0.1
 * 5.4. Построить пирамиду в псевдографике.
 * Метод должен рисовать пирамиду из символа ^ и пробелов.
 * Для высоты 2 пирамида будет иметь вид:
 *  ^
 * ^^^
 * 2 цикла: внешний отвечает за высоту пирамиды, вложенный отвечает за ширину пирамиды.
 *
 * 5.5. Рефакторинг кода -это изменения кода внутри класса без изменения внешнего АПИ.
 */

public class Paint {
    public String rightTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= column
        );
    }

    public String leftTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= height - column - 1
        );
    }

    public String pyramid(int height) {
        return this.loopBy(
                height,
                2 * height - 1,
                (row, column) -> row >= height - column - 1 && row + height - 1 >= column
        );
    }

    private String loopBy(int height, int widht, BiPredicate<Integer, Integer> predict) {
        // ширина будет равна высоте.
        StringBuilder screen = new StringBuilder();
        // Класс StringBuilder служит для построения строки, метод append добавляет символы и строки в некоторый буфер StringBuilder-а вместо вывода на консоль.
        // При вызове метода toString для StringBuilder  он возвращает все добавленные в него символы и строки в одну строку.
        // внешний цикл двигается по строкам.
        for (int row = 0; row != height; row++) {
            // внутренний цикл определяет положение ячейки в строке.
            for (int column = 0; column != widht; column++) {
                // если строка равна ячейки, то рисуем галку.
                // в данном случае строка определяем, сколько галок будет на строке
                if (predict.test(row, column)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            // добавляем перевод строки
            screen.append(System.lineSeparator());
            // Высота пирамиды достигается за счёт переходов на новую линию. В Windows это "\r\n"
            // System.getProperty("line.separator") автоматически определяет переход в зависимости от ОС
        }
        return screen.toString();
    }
}