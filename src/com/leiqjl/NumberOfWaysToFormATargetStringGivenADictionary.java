package com.leiqjl;

/**
 * 1639. Number of Ways to Form a Target String Given a Dictionary - Hard
 */
public class NumberOfWaysToFormATargetStringGivenADictionary {
    public int numWays(String[] words, String target) {
        int n = target.length();
        int m = words[0].length();
        int[][] count = new int[m][26];
        for (int i = 0; i < m; i++) {
            for (String w : words) {
                count[i][w.charAt(i) - 'a']++;
            }
        }
        int mod = 1000000007;
        long[][] dp = new long[n + 1][m + 1];
        dp[0][0] = 1;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i < n) {
                    dp[i + 1][j + 1] = count[j][target.charAt(i) - 'a'] * dp[i][j] % mod;
                }
                dp[i][j + 1] = (dp[i][j + 1] + dp[i][j]) % mod;
            }
        }
        return (int) dp[n][m];
    }
}
