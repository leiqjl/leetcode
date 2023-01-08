package com.leiqjl;

import java.util.Arrays;

/**
 * 1833. Maximum Ice Cream Bars - Medium
 */
public class MaximumIceCreamBars {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count = 0;
        for (int cost : costs) {
            if (coins >= cost) {
                coins -= cost;
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
