package com.leiqjl;

/**
 * 2466. Count Ways To Build Good Strings - Medium
 */
public class CountWaysToBuildGoodStrings {
    //Constraints:
    //
    //1 <= low <= high <= 10^5
    //1 <= zero, one <= low
    public int countGoodStrings(int low, int high, int zero, int one) {
        int mod = 1_000_000_007;
        int[] dp = new int[high + 1];
        dp[0] = 1;
        for (int i = 0; i <= high; i++) {
            if (i >= zero) {
                dp[i] += dp[i - zero];
            }
            if (i >= one) {
                dp[i] += dp[i - one];
            }
            dp[i] %= mod;
        }
        int result = 0;
        for (int i = low; i <= high; i++) {
            result += dp[i];
            result %= mod;
        }
        return result;
    }

    public static void main(String[] args) {
        CountWaysToBuildGoodStrings c = new CountWaysToBuildGoodStrings();
        assert c.countGoodStrings(3, 3, 1, 1) == 8;
        assert c.countGoodStrings(2, 3, 1, 2) == 5;
    }
}
