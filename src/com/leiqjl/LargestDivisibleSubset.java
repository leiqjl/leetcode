package com.leiqjl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 368. Largest Divisible Subset - Medium
 */
public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int[][] dp = new int[2][nums.length];
        Arrays.fill(dp[1], -1);
        Arrays.sort(nums);
        int maxIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if ((nums[i] % nums[j] == 0) && dp[0][j] + 1 > dp[0][i]) {
                    dp[0][i] = dp[0][j] + 1;
                    dp[1][i] = j;
                }
            }
            if (dp[0][i] > dp[0][maxIndex]) {
                maxIndex = i;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = maxIndex; i >= 0; i = dp[1][i]) {
            result.add(nums[i]);
        }
        return result;
    }
}
