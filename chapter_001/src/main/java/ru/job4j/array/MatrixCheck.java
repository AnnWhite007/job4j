package ru.job4j.array;

/**
 * Class MatrixCheck
 * 6.7.1. Моно строка в матрице.
 * Проверить, что строка в двухмерном массива целиком заполнена символом 'X'
 * 6.7.2. Моно столбец в матрице.
 * Аналогичный метод, который будет проверять, что все элементы в колонки заполнены символом 'X'
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
}