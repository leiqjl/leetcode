package com.leiqjl;

/**
 * 474. Ones and Zeroes - Medium
 * <p>
 * You are given an array of binary strings strs and two integers m and n.
 * <p>
 * Return the size of the largest subset of strs such that there are at most m 0's and n 1's in the subset.
 * <p>
 * A set x is a subset of a set y if all elements of x are also elements of y.
 */
public class OnesAndZeroes {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int zeroes = 0;
            int ones = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') {
                    zeroes++;
                } else {
                    ones++;
                }
            }
            for (int i = m; i >= zeroes; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroes][j - ones] + 1);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        OnesAndZeroes o = new OnesAndZeroes();
        //Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
        //Output: 4
        //Explanation: The largest subset with at most 5 0's and 3 1's is {"10", "0001", "1", "0"}, so the answer is 4.
        String[] strs = {"10", "0001", "111001", "1", "0"};
        assert o.findMaxForm(strs, 5, 3) == 4;
        //Input: strs = ["10","0","1"], m = 1, n = 1
        //Output: 2
        //Explanation: The largest subset is {"0", "1"}, so the answer is 2.
        String[] strs1 = {"10", "0", "1"};
        assert o.findMaxForm(strs1, 1, 1) == 2;
    }
}
