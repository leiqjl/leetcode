package com.leiqjl;

/**
 * 1458. Max Dot Product of Two Subsequences - Hard
 * Given two arrays nums1 and nums2.
 *
 * Return the maximum dot product between non-empty subsequences of nums1 and nums2 with the same length.
 *
 * A subsequence of a array is a new array which is formed from the original array by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters.
 * (ie, [2,3,5] is a subsequence of [1,2,3,4,5] while [1,5,3] is not).
 */
public class MaxDotProductOfTwoSubsequences {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = nums1[i] * nums2[j];
                if (i > 0 && j > 0) {
                    dp[i][j] = dp[i][j] + Math.max(0, dp[i - 1][j - 1]);
                }
                if (i > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                }
                if (j > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
                }

            }
        }
        return dp[m - 1][n - 1];
    }
}
