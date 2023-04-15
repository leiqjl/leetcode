package com.leiqjl;

import java.util.List;

/**
 * 2218. Maximum Value of K Coins From Piles - Hard
 */
public class MaximumValueOfKCoinsFromPiles {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            for (int coins = 0; coins <= k; coins++) {
                int sum = 0;
                for (int curCoins = 0; curCoins <= Math.min(piles.get(i - 1).size(), coins); curCoins++) {
                    if (curCoins > 0) {
                        sum += piles.get(i - 1).get(curCoins - 1);
                    }
                    dp[i][coins] = Math.max(dp[i][coins], dp[i - 1][coins - curCoins] + sum);
                }
            }
        }
        return dp[n][k];
    }
}
