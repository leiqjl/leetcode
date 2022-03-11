package com.leiqjl;

/**
 * 130. Surrounded Regions - Medium
 * Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
 * <p>
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * <p>
 * Constraints:
 * - m == board.length
 * - n == board[i].length
 * - 1 <= m, n <= 200
 * - board[i][j] is 'X' or 'O'.
 * <p>
 * X X X X       X X X X
 * X O O X   ->  X X X X
 * X X O X       X X X X
 * X O X X       X O X X
 */
public class SurroundedRegions {

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(board, m, n, i, 0);
            }
            if (board[i][n - 1] == 'O') {
                dfs(board, m, n, i, n - 1);
            }
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                dfs(board, m, n, 0, j);
            }
            if (board[m - 1][j] == 'O') {
                dfs(board, m, n, m - 1, j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '-') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int m, int n, int i, int j) {
        if (i >= m || i < 0 || j >= n || j < 0) {
            return;
        }
        if (board[i][j] != 'O') {
            return;
        }
        board[i][j] = '-';
        dfs(board, m, n, i + 1, j);
        dfs(board, m, n, i - 1, j);
        dfs(board, m, n, i, j + 1);
        dfs(board, m, n, i, j - 1);
    }

}
