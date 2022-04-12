package com.leiqjl;

/**
 * 419. Battleships in a Board - Medium
 */
public class BattleshipsInABoard {
    public int countBattleships(char[][] board) {
        int m = board.length, n = board[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.' || (i > 0 && board[i - 1][j] == 'X') || (j > 0 && board[i][j - 1] == 'X')) {
                    continue;
                }
                count++;
            }
        }
        return count;
    }
}
