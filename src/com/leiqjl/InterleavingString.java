package com.leiqjl;

/**
 * 97. Interleaving String - Medium
 */
public class InterleavingString {

    //0 <= s1.length, s2.length <= 100
    //0 <= s3.length <= 200
    //s1, s2, and s3 consist of lowercase English letters.

    //time O(mn) space O(n)
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int m = s1.length(), n = s2.length();
        boolean[] dp = new boolean[n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    dp[j] = true;
                } else if (i == 0) {
                    dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    dp[j] = (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) ||
                            (dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[n];
    }

    public boolean isInterleave1(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int m = s1.length(), n = s2.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    dp[i][j] = (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) ||
                            (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        InterleavingString i = new InterleavingString();
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        assert i.isInterleave(s1, s2, s3);
        assert !i.isInterleave("aabcc", "dbbca", "aadbbbaccc");
        assert i.isInterleave("", "", "");
        assert !i.isInterleave("a", "b", "a");

    }

}
