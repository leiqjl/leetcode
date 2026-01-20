package com.leiqjl;

/**
 * 712. Minimum ASCII Delete Sum for Two Strings - Medium
 * Given two strings s1 and s2, return the lowest ASCII sum of deleted characters to make two strings equal.
 */
public class MinimumASCIIDeleteSumForTwoStrings {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + s1.charAt(i - 1), dp[i][j - 1] + s2.charAt(j - 1));
                }
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args) {
        MinimumASCIIDeleteSumForTwoStrings m = new MinimumASCIIDeleteSumForTwoStrings();
        //Input: s1 = "sea", s2 = "eat"
        //Output: 231
        //Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
        //Deleting "t" from "eat" adds 116 to the sum.
        //At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.
        assert m.minimumDeleteSum("sea", "eat") == 231;
        //Input: s1 = "delete", s2 = "leet"
        //Output: 403
        assert m.minimumDeleteSum("delete", "leet") == 403;
    }
}
