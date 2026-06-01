package com.leiqjl;

import java.util.Arrays;

/**
 * 2144. Minimum Cost of Buying Candies With Discount - Easy
 */
public class MinimumCostOfBuyingCandiesWithDiscount {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int n = cost.length;
        int i = 1;
        int res = 0;
        while (i <= n) {
            if (i % 3 != 0) {
                res += cost[i];
            }
            i++;
        }
        return res;
    }
}
