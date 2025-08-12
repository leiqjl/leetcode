package com.leiqjl;

/**
 * 2787. Ways to Express an Integer as Sum of Powers - Medium
 */
public class WaysToExpressAnIntegerAsSumOfPowers {

    //Constraints:
    //
    //1 <= n <= 300
    //1 <= x <= 5
    public int numberOfWays(int n, int x) {
        int mod = 1000000007;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int val = (int) Math.pow(i, x);
            if (val > n) {
                break;
            }
            for (int j = n; j >= val; j--) {
                dp[j] = (dp[j] + dp[j - val]) % mod;
            }
        }
        return (int) dp[n];
    }

    public static void main(String[] args) {
        WaysToExpressAnIntegerAsSumOfPowers w = new WaysToExpressAnIntegerAsSumOfPowers();
        assert w.numberOfWays(10, 2) == 1;
        assert w.numberOfWays(4, 1) == 2;
    }
}
