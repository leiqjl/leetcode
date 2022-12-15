package com.leiqjl;

/**
 * 1143. Longest Common Subsequence - Medium
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 * If there is no common subsequence, return 0.
 * <p>
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
 * <p>
 * - For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[2][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[1 - i % 2][j + 1] = text1.charAt(i) == text2.charAt(j) ? dp[i % 2][j] + 1 : Math.max(dp[1 - i % 2][j], dp[i % 2][j + 1]);
            }
        }
        return dp[m % 2][n];
    }

    public int longestCommonSubsequence1(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i + 1][j + 1] = text1.charAt(i) == text2.charAt(j) ? dp[i][j] + 1 : Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        return dp[m + 1][n + 1];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence l = new LongestCommonSubsequence();
        assert l.longestCommonSubsequence("abcde", "ace") == 3;
        assert l.longestCommonSubsequence("abc", "abc") == 3;
        assert l.longestCommonSubsequence("abc", "def") == 0;
    }
}
