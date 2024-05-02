package com.leiqjl;

import java.util.Arrays;

/**
 * 2441. Largest Positive Integer That Exists With Its Negative - Easy
 */
public class LargestPositiveIntegerThatExistsWithItsNegative {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (-nums[l] == nums[r]) {
                return nums[r];
            } else if (-nums[l] > nums[r]) {
                l++;
            } else {
                r--;
            }
        }
        return -1;
    }
}
