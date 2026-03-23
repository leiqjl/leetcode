package com.leiqjl;

/**
 * 1594. Maximum Non Negative Product in a Matrix - Medium
 */
public class MaximumNonNegativeProductInAMatrix {
    public int maxProductPath(int[][] grid) {
        int mod = 1_000_000_007;
        int m = grid.length;
        int n = grid[0].length;
        long[][] maxDp = new long[m][n];
        long[][] minDp = new long[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    minDp[i][j] = maxDp[i][j] = grid[i][j];
                } else if (i == 0) {
                    minDp[i][j] = maxDp[i][j] = grid[i][j] * maxDp[i][j - 1];
                } else if (j == 0) {
                    minDp[i][j] = maxDp[i][j] = grid[i][j] * maxDp[i - 1][j];
                } else {
                    if (grid[i][j] >= 0) {
                        maxDp[i][j] = Math.max(maxDp[i][j - 1], maxDp[i - 1][j]) * grid[i][j];
                        minDp[i][j] = Math.min(minDp[i][j - 1], minDp[i - 1][j]) * grid[i][j];
                    } else {
                        maxDp[i][j] = Math.min(minDp[i][j - 1], minDp[i - 1][j]) * grid[i][j];
                        minDp[i][j] = Math.max(maxDp[i][j - 1], maxDp[i - 1][j]) * grid[i][j];
                    }
                }
            }
        }
        return maxDp[m - 1][n - 1] < 0 ? -1 : (int) (maxDp[m - 1][n - 1] % mod);
    }
}
