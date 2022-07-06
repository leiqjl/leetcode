package com.leiqjl;

import java.util.Arrays;

/**
 * 188. Best Time to Buy and Sell Stock IV - Hard
 * <p>
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.
 * <p>
 * Find the maximum profit you can achieve. You may complete at most k transactions.
 * <p>
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 */
public class BestTimeToBuyAndSellStockIV {
    //0 <= k <= 100
    //0 <= prices.length <= 1000
    //0 <= prices[i] <= 1000
    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices.length <= 1) {
            return 0;
        }
        int n = prices.length;
        if (k >= n / 2) {
            int maxProfit = 0;
            for (int i = 1; i < n; i++) {
                int diff = prices[i] - prices[i - 1];
                if (diff > 0) {
                    maxProfit += diff;
                }
            }
            return maxProfit;
        }
        int[] dp = new int[k + 1];
        int[] min = new int[k + 1];
        Arrays.fill(min, prices[0]);
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                min[j] = Math.min(min[j], prices[i] - dp[j - 1]);
                dp[j] = Math.max(dp[j], prices[i] - min[j]);
            }
        }
        return dp[k];
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockIV b = new BestTimeToBuyAndSellStockIV();
        //Input: k = 2, prices = [2,4,1]
        //Output: 2
        //Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
        int[] prices = {2, 4, 1};
        assert b.maxProfit(2, prices) == 2;
        //Input: k = 2, prices = [3,2,6,5,0,3]
        //Output: 7
        //Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
        int[] prices1 = {3, 2, 6, 5, 0, 3};
        assert b.maxProfit(2, prices1) == 7;
    }
}
