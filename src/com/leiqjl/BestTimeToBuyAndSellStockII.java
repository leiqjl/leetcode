package com.leiqjl;

/**
 * 122. Best Time to Buy and Sell Stock II - Medium
 * <p>
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time.
 * However, you can buy it then immediately sell it on the same day.
 * <p>
 * Find and return the maximum profit you can achieve.
 */
public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        int i = 0, buy = 0, sell = 0;
        while (i < n - 1) {
            while (i < n - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            buy = prices[i];
            while (i < n - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            sell = prices[i];
            maxProfit += (sell - buy);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockII b = new BestTimeToBuyAndSellStockII();
        //Input: prices = [7,1,5,3,6,4]
        //Output: 7
        //Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
        //Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
        //Total profit is 4 + 3 = 7.
        int[] prices = {7, 1, 5, 3, 6, 4};
        assert b.maxProfit(prices) == 7;
        //Input: prices = [1,2,3,4,5]
        //Output: 4
        //Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
        //Total profit is 4.
        int[] prices1 = {1, 2, 3, 4, 5};
        assert b.maxProfit(prices1) == 4;
        //Input: prices = [7,6,4,3,1]
        //Output: 0
        //Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
        int[] prices2 = {7, 6, 4, 3, 1};
        assert b.maxProfit(prices2) == 0;
    }
}
