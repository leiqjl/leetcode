package com.leiqjl;

/**
 * 87. Scramble String - Hard
 */
public class ScrambleString {
    //Constraints:
    //
    //s1.length == s2.length
    //1 <= s1.length <= 30
    //s1 and s2 consist of lowercase English letters.
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        boolean[][][] dp = new boolean[n + 1][n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[1][i][j] = s1.charAt(i) == s2.charAt(j);
            }
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n + 1 - len; i++) {
                for (int j = 0; j < n + 1 - len; j++) {
                    for (int newLen = 1; newLen < len; newLen++) {
                        dp[len][i][j] |= (dp[newLen][i][j] && dp[len - newLen][i + newLen][j + newLen]);
                        dp[len][i][j] |= (dp[newLen][i][j + len - newLen] && dp[len - newLen][i + newLen][j]);
                    }
                }
            }
        }
        return dp[n][0][0];
    }

    public static void main(String[] args) {
        ScrambleString s = new ScrambleString();
        assert s.isScramble("great", "rgeat");
        assert !s.isScramble("abcde", "caebd");
        assert s.isScramble("a", "a");
    }
}
