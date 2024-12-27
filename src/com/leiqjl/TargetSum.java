package com.leiqjl;

import java.util.Arrays;

/**
 * 494. Target Sum - Medium
 */
public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        if (Math.abs(target) > totalSum) {
            return 0;
        }
        int[][] dp = new int[2][totalSum * 2 + 1];
        dp[0][nums[0] + totalSum] += 1;
        dp[0][-nums[0] + totalSum] += 1;
        int curIndex = 0, nextIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            Arrays.fill(dp[nextIndex], 0);
            for (int j = -totalSum; j <= totalSum; j++) {
                if (dp[curIndex][j + totalSum] == 0) {
                    continue;
                }
                dp[nextIndex][nums[i] + j + totalSum] += dp[curIndex][j + totalSum];
                dp[nextIndex][-nums[i] + j + totalSum] += dp[curIndex][j + totalSum];
            }
            curIndex = 1 - curIndex;
            nextIndex = 1 - nextIndex;
        }
        return dp[curIndex][target + totalSum];
    }
}
