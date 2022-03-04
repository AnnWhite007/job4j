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
 *
 *
 *
 *
 *
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

    /**
     * Класс StringBuilder служит для построения строки, метод append добавляет символы и строки в некоторый буфер StringBuilder-а вместо вывода на консоль.
     * При вызове метода toString для StringBuilder  он возвращает все добавленные в него символы и строки в одну строку.
     * Ширина будет равна высоте.
     * Внешний цикл двигается по строкам.
     * Внутренний цикл определяет положение ячейки в строке.
     * Если строка равна ячейки, то рисуем галку.
     * В данном случае строка определяем, сколько галок будет на строке
     * Добавляем перевод строки.
     * Высота пирамиды достигается за счёт переходов на новую линию. В Windows это "\r\n"
     * System.getProperty("line.separator") автоматически определяет переход в зависимости от ОС
     */
    private String loopBy(int height, int widht, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != widht; column++) {
                if (predict.test(row, column)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}