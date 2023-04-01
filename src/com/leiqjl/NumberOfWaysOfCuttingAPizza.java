package com.leiqjl;

/**
 * 1444. Number of Ways of Cutting a Pizza - Hard
 */
public class NumberOfWaysOfCuttingAPizza {
    public int ways(String[] pizza, int k) {
        int mod = 1000000007;
        int rows = pizza.length;
        int cols = pizza[0].length();
        int[][] appleCount = new int[rows + 1][cols + 1];
        int[][][] dp = new int[k][rows][cols];
        for (int r = rows - 1; r >= 0; r--) {
            for (int c = cols - 1; c >= 0; c--) {
                appleCount[r][c] = appleCount[r + 1][c] + appleCount[r][c + 1] - appleCount[r + 1][c + 1]
                        + (pizza[r].charAt(c) == 'A' ? 1 : 0);
                dp[0][r][c] = appleCount[r][c] > 0 ? 1 : 0;
            }
        }
        for (int remain = 1; remain < k; remain++) {
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    for (int nextRow = r + 1; nextRow < rows; nextRow++) {
                        if (appleCount[r][c] - appleCount[nextRow][c] > 0) {
                            dp[remain][r][c] = (dp[remain][r][c] + dp[remain - 1][nextRow][c]) % mod;
                        }
                    }
                    for (int nextCol = c + 1; nextCol < cols; nextCol++) {
                        if (appleCount[r][c] - appleCount[r][nextCol] > 0) {
                            dp[remain][r][c] = (dp[remain][r][c] + dp[remain - 1][r][nextCol]) % mod;
                        }
                    }
                }
            }
        }
        return dp[k - 1][0][0];
    }
}
