package ru.job4j.array;

/**
 * Class MatrixCheck
 * 6.7.1. Моно строка в матрице.
 * Проверить, что строка в двухмерном массива целиком заполнена символом 'X'
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
}