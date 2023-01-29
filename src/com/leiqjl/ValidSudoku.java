package com.leiqjl;

/**
 * 36. Valid Sudoku - Medium
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] seen1 = new boolean[9][9];
        boolean[][] seen2 = new boolean[9][9];
        boolean[][] seen3 = new boolean[9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int num = board[i][j] - '1';
                int k = i / 3 * 3 + j / 3;
                if (seen1[i][num] | seen2[j][num] | seen3[k][num]) {
                    return false;
                }
                seen1[i][num] = true;
                seen2[j][num] = true;
                seen3[k][num] = true;
            }
        }
        return true;
    }
}
