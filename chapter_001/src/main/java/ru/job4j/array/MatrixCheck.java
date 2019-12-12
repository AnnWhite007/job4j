package ru.job4j.array;

public class MatrixCheck {
    public static boolean isWin(char[][] board) {
        boolean result = false;
        for (int row = 0; row < board.length; row++) {
            for (int cell = 0; cell < board.length; cell++) {
                char sign = board[row][cell];
                System.out.print(sign);
                //for () { проверить последовательность.
                for (cell = 0; cell < board.length; cell++) {
                    if (board[0][cell] == 'X') {
                        for (row = 0; row < board.length; row++) {
                            if (board[row][cell] == 'X') {
                                result = true;
                            } else {
                                result = false;
                                break;
                            }
                        }
                    } else {
                        for (row = 0; row < board.length; row++) {
                            if (board[row][0] == 'X') {
                                for (cell = 0; cell < board.length; cell++) {
                                    if (board[row][cell] == 'X') {
                                        result = true;
                                    } else {
                                        result = false;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            System.out.println();
        }
        return result;
    }

    public static void main(String[] args) {
        char[][] hasWinVertical = {
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
        };
        boolean win = isWin(hasWinVertical);
        System.out.println("A board has a winner : " + win);
        System.out.println();
        char[][] hasWinHor = {
                {'_', '_', '_', '_', '_'},
                {'X', 'X', 'X', 'X', 'X'},
                {'_', '_', '_', '_', '_'},
                {'_', '_', '_', '_', '_'},
                {'_', '_', '_', '_', '_'},
        };
        boolean winHor = isWin(hasWinHor);
        System.out.println("A board has a winner : " + winHor);
        System.out.println();
        char[][] notWin = {
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', 'X', '_', '_', '_'},
                {'_', '_', 'X', '_', '_'},
                {'_', '_', 'X', '_', '_'},
        };
        boolean lose = isWin(notWin);
        System.out.println("A board has a winner : " + lose);
    }
}