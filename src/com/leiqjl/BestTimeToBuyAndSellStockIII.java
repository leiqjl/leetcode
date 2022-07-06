package com.leiqjl;

import java.util.Arrays;

/**
 * 123. Best Time to Buy and Sell Stock III - Hard
 * <p>
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * Find the maximum profit you can achieve. You may complete at most two transactions.
 * <p>
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 */
public class BestTimeToBuyAndSellStockIII {

    //time O(n) space O(1)
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MAX_VALUE, buy2 = Integer.MAX_VALUE;
        int profit1 = 0, profit2 = 0;
        for (int price : prices) {
            buy1 = Math.min(buy1, price);
            profit1 = Math.max(profit1, price - buy1);
            buy2 = Math.min(buy2, price - profit1);
            profit2 = Math.max(profit2, price - buy2);
        }
        return profit2;
    }

    //dp[k, i] = max(dp[k, i-1], prices[i] - prices[j] + dp[k-1, j-1]), j=[0..i-1]
    //time O(kn^2) space O(kn)
    public int maxProfit1(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[3][n];
        for (int k = 1; k <= 2; k++) {
            for (int i = 1; i < n; i++) {
                int min = prices[0];
                for (int j = 1; j <= i; j++) {
                    min = Math.min(min, prices[j] - dp[k - 1][j - 1]);
                }
                dp[k][i] = Math.max(dp[k][i - 1], prices[i] - min);
            }
        }
        return dp[2][n - 1];
    }

    //time O(kn) space O(kn)
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[3][n];
        for (int k = 1; k <= 2; k++) {
            int min = prices[0];
            for (int i = 1; i < n; i++) {
                min = Math.min(min, prices[i] - dp[k - 1][i - 1]);
                dp[k][i] = Math.max(dp[k][i - 1], prices[i] - min);
            }
        }
        return dp[2][n - 1];
    }

    //time O(kn) space O(kn)
    public int maxProfit3(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[3][n];
        int[] min = new int[3];
        Arrays.fill(min, prices[0]);
        for (int i = 1; i < n; i++) {
            for (int k = 1; k <= 2; k++) {
                min[k] = Math.min(min[k], prices[i] - dp[k - 1][i - 1]);
                dp[k][i] = Math.max(dp[k][i - 1], prices[i] - min[k]);
            }
        }
        return dp[2][n - 1];
    }

    //time O(kn) space O(k)
    public int maxProfit4(int[] prices) {
        int n = prices.length;
        int[] dp = new int[3];
        int[] min = new int[3];
        Arrays.fill(min, prices[0]);
        for (int i = 1; i < n; i++) {
            for (int k = 1; k <= 2; k++) {
                min[k] = Math.min(min[k], prices[i] - dp[k - 1]);
                dp[k] = Math.max(dp[k], prices[i] - min[k]);
            }
        }
        return dp[2];
    }


    public static void main(String[] args) {
        BestTimeToBuyAndSellStockIII b = new BestTimeToBuyAndSellStockIII();
        //Input: prices = [3,3,5,0,0,3,1,4]
        //Output: 6
        //Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
        //Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        assert b.maxProfit(prices) == 6;
        //Input: prices = [1,2,3,4,5]
        //Output: 4
        //Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
        //Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
        int[] prices1 = {1, 2, 3, 4, 5};
        assert b.maxProfit(prices1) == 4;
        //Input: prices = [7,6,4,3,1]
        //Output: 0
        //Explanation: In this case, no transaction is done, i.e. max profit = 0.
        int[] prices2 = {7, 6, 4, 3, 1};
        assert b.maxProfit(prices2) == 0;
    }
}
