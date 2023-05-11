package com.leiqjl;

/**
 * 1035. Uncrossed Lines - Medium
 */
public class UncrossedLines {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i + 1][j + 1] = nums1[i] == nums2[j] ? dp[i][j] + 1 : Math.max(dp[i][j + 1], dp[i + 1][j]);
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        UncrossedLines u = new UncrossedLines();
        assert u.maxUncrossedLines(new int[]{1, 4, 2}, new int[]{1, 2, 4}) == 2;
        assert u.maxUncrossedLines(new int[]{2, 5, 1, 2, 5}, new int[]{10, 5, 2, 1, 5, 2}) == 3;
        assert u.maxUncrossedLines(new int[]{1, 3, 7, 1, 7, 5}, new int[]{1, 9, 2, 5, 1}) == 2;
    }
}
