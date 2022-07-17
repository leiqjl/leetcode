package com.leiqjl;

/**
 * 629. K Inverse Pairs Array - Hard
 */
public class KInversePairsArray {
    //1 <= n <= 1000
    //0 <= k <= 1000
    public int kInversePairs(int n, int k) {
        if (k == 0 || k == n * (n - 1) / 2) {
            return 1;
        }
        if (k > n * (n - 1) / 2) {
            return 0;
        }
        int mod = 1000000007;
        int[][] dp = new int[n + 1][k + 1];
        //dp[n][k] = dp[n-1][k]+dp[n-1][k-1]+dp[n-1][k-2]+...+dp[n-1][k+1-n+1]+dp[n-1][k-n+1]   (1)
        //dp[n][k+1] = dp[n - 1][k+1] + dp[n - 1][k] + ... + dp[n - 1][k + 1 - n + 1]           (2)

        //dp[n][k+1] = dp[n][k]+dp[n-1][k+1]-dp[n-1][k+1-n]   (2) - (1)
        //dp[n][k] = dp[n][k-1]+dp[n-1][k]-dp[n-1][k-n]        k+1 -> k
        dp[2][0] = 1;
        dp[2][1] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= Math.min(k, i * (i - 1) / 2); j++) {
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % mod;
                if (j >= i) {
                    dp[i][j] = (dp[i][j] - dp[i - 1][j - i] + mod) % mod;
                }
            }
        }
        return dp[n][k];
    }
}
