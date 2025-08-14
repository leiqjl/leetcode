package com.leiqjl;

/**
 * 3239. Minimum Number of Flips to Make Binary Grid Palindromic I - Medium
 */
public class MinimumNumberOfFlipsToMakeBinaryGridPalindromicI {
    public int minFlips(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;


        int rowCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n / 2; j++) {
                if (grid[i][j] != grid[i][n - 1 - j]) {
                    rowCount++;
                }
            }
        }
        int colCount = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m / 2; i++) {
                if (grid[i][j] != grid[m - 1 - i][j]) {
                    colCount++;
                }
            }
        }
        return Math.min(rowCount, colCount);
    }
}
