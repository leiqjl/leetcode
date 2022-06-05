package com.leiqjl;

/**
 * 52. N-Queens II - Hard
 */
public class NQueensII {
    int count = 0;
    boolean[] flagCol;
    boolean[] flag45;
    boolean[] flag135;

    public int totalNQueens(int n) {
        flagCol = new boolean[n];
        flag45 = new boolean[2 * n - 1];
        flag135 = new boolean[2 * n - 1];
        dfs(0, n);
        return count;
    }


    private void dfs(int curRow, int n) {
        if (curRow == n) {
            count++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (flagCol[col] || flag45[col + curRow] || flag135[col - curRow + n - 1]) {
                continue;
            }
            flagCol[col] = flag45[col + curRow] = flag135[col - curRow + n - 1] = true;
            dfs(curRow + 1, n);
            flagCol[col] = flag45[col + curRow] = flag135[col - curRow + n - 1] = false;
        }
    }

}
