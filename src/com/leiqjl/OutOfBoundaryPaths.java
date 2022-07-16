package com.leiqjl;

/**
 * 576. Out of Boundary Paths - Medium
 */
public class OutOfBoundaryPaths {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int count = 0;
        int mod = 1000000007;
        int[][] dp = new int[m][n];
        dp[startRow][startColumn] = 1;
        for (int move = 1; move <= maxMove; move++) {
            int[][] tempDp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0) {
                        count = (count + dp[i][j]) % mod;
                    }
                    if (i == m - 1) {
                        count = (count + dp[i][j]) % mod;
                    }
                    if (j == 0) {
                        count = (count + dp[i][j]) % mod;
                    }
                    if (j == n - 1) {
                        count = (count + dp[i][j]) % mod;
                    }
                    if (i > 0) {
                        tempDp[i][j] = (tempDp[i][j] + dp[i - 1][j]) % mod;
                    }
                    if (i < m - 1) {
                        tempDp[i][j] = (tempDp[i][j] + dp[i + 1][j]) % mod;
                    }
                    if (j > 0) {
                        tempDp[i][j] = (tempDp[i][j] + dp[i][j - 1]) % mod;
                    }
                    if (j < n - 1) {
                        tempDp[i][j] = (tempDp[i][j] + dp[i][j + 1]) % mod;
                    }
                }
            }
            dp = tempDp;
        }
        return count;
    }

    public static void main(String[] args) {
        OutOfBoundaryPaths o = new OutOfBoundaryPaths();
        //Input: m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
        //Output: 6
        assert o.findPaths(2, 2, 2, 0, 0) == 6;
        //Input: m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
        //Output: 12
        assert o.findPaths(1, 3, 3, 0, 1) == 12;

        assert o.findPaths(8, 50, 23, 5, 26) == 914783380;
    }
}
