package com.leiqjl;

import java.util.Arrays;

/**
 * 62. Unique Paths - Medium
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        UniquePaths u = new UniquePaths();
        //Input: m = 3, n = 7
        //Output: 28
        assert u.uniquePaths(3, 7) == 28;
        //Input: m = 3, n = 2
        //Output: 3
        assert u.uniquePaths(3, 2) == 3;
    }
}
