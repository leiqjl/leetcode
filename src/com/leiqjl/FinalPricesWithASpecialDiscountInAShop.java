package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1475. Final Prices With a Special Discount in a Shop - Easy
 * You are given an integer array prices where prices[i] is the price of the ith item in a shop.
 * <p>
 * There is a special discount for items in the shop. If you buy the ith item, then you will receive a discount equivalent to prices[j] where j is the minimum index such that j > i and prices[j] <= prices[i]. Otherwise, you will not receive any discount at all.
 * <p>
 * Return an integer array answer where answer[i] is the final price you will pay for the ith item of the shop, considering the special discount.
 */
public class FinalPricesWithASpecialDiscountInAShop {
    public int[] finalPrices(int[] prices) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int pop = stack.pop();
                prices[pop] -= prices[i];
            }
            stack.push(i);
        }
        return prices;
    }
}
