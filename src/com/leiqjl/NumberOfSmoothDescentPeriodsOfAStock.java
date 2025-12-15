package com.leiqjl;

/**
 * 2110. Number of Smooth Descent Periods of a Stock - Medium
 */
public class NumberOfSmoothDescentPeriodsOfAStock {
    public long getDescentPeriods(int[] prices) {
        long res = 1;
        int prev = 1;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] == prices[i - 1] - 1) {
                prev++;
            } else {
                prev = 1;
            }
            res += prev;
        }
        return res;
    }
}
