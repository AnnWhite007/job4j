package ru.job4j.array;

/**
 * Class MatrixCheck
 * 6.7.1. Моно строка в матрице.
 * Проверить, что строка в двухмерном массива целиком заполнена символом 'X'
 * 6.7.2. Моно столбец в матрице.
 * Аналогичный метод, который будет проверять, что все элементы в колонки заполнены символом 'X'
 * 6.7.3. Массив из диагонали матрицы.
 * Заполнить одномерный массив элементами диагонали из двухмерного массива
 * 6.7.4. Выигрышные комбинации в сокобан.
 * Цель игры расположить крестики в линию на 5 элементов. Элементы X должны располагаться, либо вертикально, либо горизонтально.
 * Написать метод, который будет проверять, что на поле находится выигрышная ситуация.
 * При любой выигрышной комбинации элементы всегда пересекают диагональ.
 * Определяем координаты элемента в диагонали и проверяет вертикальную линию и горизонтальную линию.
 */

public class MatrixCheck {
    public static boolean monoHorizontal(char[][] board, int row) {
        boolean result = true;
        for (int index = 0; index < board.length; index++) {
            if (board[row][index] != 'X') {
                result = false;
                break;
            }
        }
        return result;
    }

    public static boolean monoVertical(char[][] board, int column) {
        boolean result = true;
        for (int index = 0; index < board.length; index++) {
            if (board[index][column] != 'X') {
                result = false;
                break;
            }
        }
        return result;
    }

    public static char[] extractDiagonal(char[][] board) {
        char[] rsl = new char[board.length];
        for (int index = 0; index < board.length; index++) {
            rsl[index] = board[index][index];
        }
        return rsl;
    }

    /**
     * Метод должен проверить, что в квадратном массиве есть строчки или столбцы заполненные только символов 'X'.
     * При любой выигрышной комбинации элементы всегда пересекают диагональ. Это дает нам возможность сократить количество проходов.
     * Мы определяем координаты элемента в диагонали и проверяет вертикальную линию и горизонтальную линию.
     */
    public static boolean isWin(char[][] board) {
        boolean result = false;
        for (int index = 0; index < board.length; index++) {
            if (board[index][index] == 'X') {
                if (monoHorizontal(board, index) || monoVertical(board, index))
                result = true;
                break;
            }
        }
        return result;
    }
}