package com.leiqjl;

import java.util.Arrays;

/**
 * 1984. Minimum Difference Between Highest and Lowest of K Scores - Easy
 * You are given a 0-indexed integer array nums, where nums[i] represents the score of the ith student. You are also given an integer k.
 * <p>
 * Pick the scores of any k students from the array so that the difference between the highest and the lowest of the k scores is minimized.
 * <p>
 * Return the minimum possible difference.
 */
public class MinimumDifferenceBetweenHighestAndLowestOfKScores {
    public int minimumDifference(int[] nums, int k) {
        if (k == 1) {
            return 0;
        }
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        for (int i = k - 1; i < nums.length; i++) {
            minDiff = Math.min(minDiff, nums[i] - nums[i - k + 1]);
        }

        return minDiff;
    }
}
