package com.leiqjl;

/**
 * 91. Decode Ways - Medium
 */
public class DecodeWays {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int prev = s.charAt(0) - '0';
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < n; i++) {
            int cur = s.charAt(i) - '0';
            if (cur >= 1 && cur <= 9) {
                dp[i + 1] += dp[i];
            }
            int sum = prev * 10 + cur;
            if (sum >= 10 && sum <= 26) {
                dp[i + 1] += dp[i - 1];
            }
            prev = cur;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        DecodeWays d = new DecodeWays();

        assert d.numDecodings("12") == 2;
        assert d.numDecodings("226") == 3;
        assert d.numDecodings("06") == 0;
        assert d.numDecodings("10") == 1;
        assert d.numDecodings("100") == 0;
    }
}
