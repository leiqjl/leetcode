package com.leiqjl;

/**
 * 1312. Minimum Insertion Steps to Make a String Palindrome - Hard
 */
public class MinimumInsertionStepsToMakeAStringPalindrome {
    public int minInsertions(String s) {
        int n = s.length();
        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = 1;
            int prev = 0;
            for (int j = i + 1; j < n; j++) {
                int temp = dp[j];
                if (s.charAt(i) == s.charAt(j)) {
                    dp[j] = prev + 2;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                prev = temp;
            }
        }
        return n - dp[n - 1];
    }
    public int minInsertions1(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return n - dp[0][n - 1];
    }

    public static void main(String[] args) {
        MinimumInsertionStepsToMakeAStringPalindrome m = new MinimumInsertionStepsToMakeAStringPalindrome();
        assert m.minInsertions("zzazz") == 0;
        assert m.minInsertions("mbadm") == 2;
        assert m.minInsertions("leetcode") == 5;
    }
}
