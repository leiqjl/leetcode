package com.leiqjl;

/**
 * 1092. Shortest Common Supersequence - Hard
 * Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences. If there are multiple valid strings, return any of them.
 * <p>
 * A string s is a subsequence of string t if deleting some number of characters from t (possibly 0) results in the string s.
 */
public class ShortestCommonSupersequence {

    //Constraints:
    //
    //1 <= str1.length, str2.length <= 1000
    //str1 and str2 consist of lowercase English letters.
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // add one of the two characters
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (m > 0 && n > 0) {
            if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
                sb.append(str1.charAt(m - 1));
                m--;
                n--;
            } else if (dp[m - 1][n] < dp[m][n - 1]) {
                sb.append(str1.charAt(m - 1));
                m--;
            } else {
                sb.append(str2.charAt(n - 1));
                n--;
            }
        }
        while (m > 0) {
            sb.append(str1.charAt(m - 1));
            m--;
        }
        while (n > 0) {
            sb.append(str2.charAt(n - 1));
            n--;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        ShortestCommonSupersequence s = new ShortestCommonSupersequence();
        //str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
        //str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
        assert s.shortestCommonSupersequence("abac", "cab").equals("cabac");
        assert s.shortestCommonSupersequence("aaaaaaaa", "aaaaaaaa").equals("aaaaaaaa");
        assert s.shortestCommonSupersequence("bbabacaa", "cccababab").equals("bbcccabacabab");
    }
}
