package com.leiqjl;

/**
 * 279. Perfect Squares - Medium
 */
public class PerfectSquares {
    //1 <= n <= 10^4
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= 100; j++) {
                if (j * j > i) {
                    break;
                }
                min = Math.min(min, dp[i - j * j] + 1);
            }
            dp[i] = min;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        PerfectSquares p = new PerfectSquares();
        //Input: n = 12
        //Output: 3
        //Explanation: 12 = 4 + 4 + 4.
        assert p.numSquares(12) == 3;
        //Input: n = 13
        //Output: 2
        //Explanation: 13 = 4 + 9.
        assert p.numSquares(13) == 2;
    }
}
