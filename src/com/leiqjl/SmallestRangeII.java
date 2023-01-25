package com.leiqjl;

import java.util.Arrays;

/**
 * 910. Smallest Range II - Medium
 * <p>
 * You are given an integer array nums and an integer k.
 * <p>
 * For each index i where 0 <= i < nums.length, change nums[i] to be either nums[i] + k or nums[i] - k.
 * <p>
 * The score of nums is the difference between the maximum and minimum elements in nums.
 * <p>
 * Return the minimum score of nums after changing the values at each index.
 */
public class SmallestRangeII {
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int result = nums[n - 1] - nums[0];
        for (int i = 0; i < n - 1; i++) {
            int max = Math.max(nums[i] + k, nums[n - 1] - k);
            int min = Math.min(nums[i + 1] - k, nums[0] + k);
            result = Math.min(max - min, result);
        }
        return result;
    }
}
