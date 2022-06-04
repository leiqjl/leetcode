package com.leiqjl;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N-Queens - Hard
 */
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] chessboard = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chessboard[i][j] = '.';
            }
        }
        dfs(chessboard, 0, result);
        return result;
    }

    private void dfs(char[][] chessboard, int curRow, List<List<String>> result) {
        if (curRow == chessboard.length) {
            addResult(chessboard, result);
            return;
        }
        for (int i = 0; i < chessboard.length; i++) {
            if (check(chessboard, i, curRow)) {
                chessboard[i][curRow] = 'Q';
                dfs(chessboard, curRow + 1, result);
                chessboard[i][curRow] = '.';
            }
        }
    }

    private void addResult(char[][] chessboard, List<List<String>> result) {
        List<String> curBoard = new ArrayList<>(chessboard.length);
        for (int i = 0; i < chessboard.length; i++) {
            curBoard.add(new String(chessboard[i]));
        }
        result.add(curBoard);
    }


    private boolean check(char[][] chessboard, int x, int y) {
        for (int i = 0; i < chessboard.length; i++) {
            for (int j = 0; j < y; j++) {
                if (chessboard[i][j] == 'Q' && (x == i || (x + j == y + i) || (x + y == i + j))) {
                    return false;
                }
            }
        }
        return true;
    }
}
