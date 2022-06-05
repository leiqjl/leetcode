package com.leiqjl;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N-Queens - Hard
 */
public class NQueens {
    boolean[] flagCol;
    boolean[] flag45;
    boolean[] flag135;

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] chessboard = new char[n][n];
        flagCol = new boolean[n];
        flag45 = new boolean[2 * n - 1];
        flag135 = new boolean[2 * n - 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chessboard[i][j] = '.';
            }
        }
        dfs(chessboard, 0, result, n);
        return result;
    }

    private void dfs(char[][] chessboard, int curRow, List<List<String>> result, int n) {
        if (curRow == n) {
            addResult(chessboard, result);
            return;
        }
        for (int i = 0; i < chessboard.length; i++) {
            if (flagCol[i] || flag45[i + curRow] || flag135[i - curRow + n - 1]) {
                continue;
            }
            flagCol[i] = flag45[i + curRow] = flag135[i - curRow + n - 1] = true;
            chessboard[i][curRow] = 'Q';
            dfs(chessboard, curRow + 1, result, n);
            chessboard[i][curRow] = '.';
            flagCol[i] = flag45[i + curRow] = flag135[i - curRow + n - 1] = false;
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
