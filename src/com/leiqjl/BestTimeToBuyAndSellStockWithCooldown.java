package com.leiqjl;

/**
 * 309. Best Time to Buy and Sell Stock with Cooldown - Medium
 */
public class BestTimeToBuyAndSellStockWithCooldown {

    //state machine
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][3];
        //0cooldown  1buy 2sell
        //0:  0 -do nothing-> 0  or 2 -cooldown-> 0
        //1:  1 -do nothing-> 1  or 0 -buy-> 1
        //2:  1 -sell-> 2
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = dp[i - 1][1] + prices[i];
        }

        return Math.max(dp[n - 1][0], Math.max(dp[n - 1][1], dp[n - 1][2]));
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithCooldown b = new BestTimeToBuyAndSellStockWithCooldown();
        //Input: prices = [1,2,3,0,2]
        //Output: 3
        //Explanation: transactions = [buy, sell, cooldown, buy, sell]
        assert b.maxProfit(new int[]{1, 2, 3, 0, 2}) == 3;
        //Input: prices = [1]
        //Output: 0
        assert b.maxProfit(new int[]{1}) == 0;
    }
}
