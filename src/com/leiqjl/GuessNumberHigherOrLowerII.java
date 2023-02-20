package com.leiqjl;

/**
 * 375. Guess Number Higher or Lower II - Medium
 */
public class GuessNumberHigherOrLowerII {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        return guess(dp, 1, n);
    }

    // 1)  3      0
    // 2)  34     first
    // 3)  345    second
    // 4)  2345  first+third
    // 5)  12345 second+forth
    private int guess(int[][] dp, int l, int r) {
        if (dp[l][r] != 0) {
            return dp[l][r];
        }
        if (r <= l) {
            return 0;
        }
        //1) + 2)
        if (r - l <= 2) {
            dp[l][r] = r - 1;
            return dp[l][r];
        }
        //3) + 4)
        if (r - l <= 4) {
            dp[l][r] = r - 3 + r - 1;
            return dp[l][r];
        }
        int mid = l + (r - l) / 2;
        int min = Integer.MAX_VALUE;
        while (mid < r) {
            int leftVal = guess(dp, l, mid - 1);
            int rightVal = guess(dp, mid + 1, r);
            int val = mid + Math.max(leftVal, rightVal);
            min = Math.min(val, min);
            if (rightVal <= leftVal) {
                break;
            }
            mid++;
        }
        dp[l][r] = min;
        return dp[l][r];
    }

    public static void main(String[] args) {
        GuessNumberHigherOrLowerII g = new GuessNumberHigherOrLowerII();
        assert g.getMoneyAmount(10) == 16;
        assert g.getMoneyAmount(1) == 0;
        assert g.getMoneyAmount(2) == 1;
    }
}
