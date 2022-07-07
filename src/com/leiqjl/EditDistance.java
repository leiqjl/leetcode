package com.leiqjl;

/**
 * 72. Edit Distance - Hard
 * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
 * <p>
 * You have the following three operations permitted on a word:
 * <p>
 * - Insert a character
 * - Delete a character
 * - Replace a character
 */
public class EditDistance {

    //time O(mn) space O(mn)
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //replace dp[i-1][j-1]+1
                    //delete  dp[i-1][j]+1
                    //insert  dp[i][j-1]+1
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[m][n];
    }
    //todo time O(mn) space O(n)

    public static void main(String[] args) {
        EditDistance e = new EditDistance();
        //Input: word1 = "horse", word2 = "ros"
        //Output: 3
        //Explanation:
        //horse -> rorse (replace 'h' with 'r')
        //rorse -> rose (remove 'r')
        //rose -> ros (remove 'e')
        assert e.minDistance("horse", "ros") == 3;
        //Input: word1 = "intention", word2 = "execution"
        //Output: 5
        //Explanation:
        //intention -> inention (remove 't')
        //inention -> enention (replace 'i' with 'e')
        //enention -> exention (replace 'n' with 'x')
        //exention -> exection (replace 'n' with 'c')
        //exection -> execution (insert 'u')
        assert e.minDistance("intention", "execution") == 5;
    }
}
