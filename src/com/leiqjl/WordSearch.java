package com.leiqjl;

/**
 * 79. Word Search - Medium
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (dfs(board, r, c, w, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int row, int col, char[] words, int idx) {
        if (idx == words.length) {
            return true;
        }
        if (row < 0 || col < 0 || row == board.length || col == board[row].length) {
            return false;
        }
        if (board[row][col] == '@' || board[row][col] != words[idx]) {
            return false;
        }
        board[row][col] = '@';
        boolean exist = dfs(board, row, col + 1, words, idx + 1)
                || dfs(board, row, col - 1, words, idx + 1)
                || dfs(board, row + 1, col, words, idx + 1)
                || dfs(board, row - 1, col, words, idx + 1);
        board[row][col] = words[idx];
        return exist;
    }
}
