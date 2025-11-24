package com.leiqjl;

import java.util.Arrays;

/**
 * 1262. Greatest Sum Divisible by Three - Medium
 */
public class GreatestSumDivisibleByThree {
    public int maxSumDivThree(int[] nums) {
        int[] dp = {0, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int num : nums) {
            int[] temp = Arrays.copyOf(dp, dp.length);
            for (int i = 0; i < 3; i++) {
                int x = (i + (num % 3)) % 3;
                temp[x] = Math.max(temp[x], dp[i] + num);
            }
            dp = temp;
        }
        return dp[0];
    }
}
