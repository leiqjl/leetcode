package com.leiqjl;

/**
 * 583. Delete Operation for Two Strings - Medium
 */
public class DeleteOperationForTwoStrings {

    //time O(m*n) space O(m*n)
    //lcs + memory
    public int minDistance1(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] mem = new int[m + 1][n + 1];
        lcs(word1, word2, m, n, mem);
        return m + n - 2 * mem[m][n];
    }

    private int lcs(String s1, String s2, int m, int n, int[][] mem) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (mem[m][n] > 0) {
            return mem[m][n];
        }
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            mem[m][n] = 1 + lcs(s1, s2, m - 1, n - 1, mem);
        } else {
            mem[m][n] = Math.max(lcs(s1, s2, m - 1, n, mem), lcs(s1, s2, m, n - 1, mem));
        }
        return mem[m][n];
    }

    //-------------
    //time O(m*n) space O(m*n)
    //dp lcs
    public int minDistance2(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return m + n - 2 * dp[m][n];
    }

    //time O(m*n) space O(n)
    //dp lcs
    public int minDistance3(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[] dp = new int[n + 1];
        int[] cur = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    cur[j] = 1 + dp[j - 1];
                } else {
                    cur[j] = Math.max(dp[j], cur[j - 1]);
                }
            }
            int[] temp = cur;
            cur = dp;
            dp = temp;
        }
        return m + n - 2 * dp[n];
    }

    //-------------
    //time O(m*n) space O(m*n)
    public int minDistance4(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // one string is "", another string all delete
                if (i == 0 || j == 0) {
                    dp[i][j] = i + j;
                } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[m][n];
    }

    //time O(m*n) space O(n)
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[] dp = new int[n + 1];
        int[] cur = new int[n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    cur[j] = i + j;
                } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    cur[j] = dp[j - 1];
                } else {
                    cur[j] = Math.min(cur[j - 1], dp[j]) + 1;
                }
            }
            int[] temp = cur;
            cur = dp;
            dp = temp;
        }
        return dp[n];
    }


    public static void main(String[] args) {
        DeleteOperationForTwoStrings d = new DeleteOperationForTwoStrings();
        //Input: word1 = "sea", word2 = "eat"
        //Output: 2
        //Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
        String word1 = "sea";
        String word2 = "eat";
        assert d.minDistance(word1, word2) == 2;
        //Input: word1 = "leetcode", word2 = "etco"
        //Output: 4
        word1 = "leetcode";
        word2 = "etco";
        assert d.minDistance(word1, word2) == 4;

    }

}
