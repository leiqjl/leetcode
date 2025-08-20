package com.leiqjl;

/**
 * 1277. Count Square Submatrices with All Ones - Medium
 */
public class CountSquareSubmatricesWithAllOnes {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] dp = new int[n + 1];
        int prev = 0;
        int count = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == 1) {
                    int temp = dp[j];
                    dp[j] = Math.min(Math.min(temp, dp[j - 1]), prev) + 1;
                    prev = temp;
                    count += dp[j];
                } else {
                    dp[j] = 0;
                }
            }
        }
        return count;
    }
}
