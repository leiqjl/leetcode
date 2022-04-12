package com.leiqjl;

/**
 * 289. Game of Life - Medium
 */
public class GameOfLife {

    //Any live cell with fewer than two live neighbors dies as if caused by under-population.
    //Any live cell with two or three live neighbors lives on to the next generation.
    //Any live cell with more than three live neighbors dies, as if by over-population.
    //Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
    //in place
    //time O(mn)
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lives = count(board, i, j, m, n);
                if (lives == 3 || (lives == 2 && board[i][j] == 1)) {
                    board[i][j] |= 2;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    private int count(int[][] board, int i, int j, int m, int n) {
        int count = - (board[i][j] & 1);
        for (int r = Math.max(0, i - 1); r <= Math.min(m - 1, i + 1); r++) {
            for (int c = Math.max(0, j - 1); c <= Math.min(n - 1, j + 1); c++) {
                count += (board[r][c] & 1);
            }
        }
        return count;
    }
}
