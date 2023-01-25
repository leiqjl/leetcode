package com.leiqjl;

/**
 * 908. Smallest Range I - Easy
 */
public class SmallestRangeI {
    public int smallestRangeI(int[] nums, int k) {
        int n = nums.length;
        int max = nums[0], min = nums[0];
        for (int num : nums) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
        int result = max - min;
        if (result <= 2 * k) {
            return 0;
        }
        return result - 2 * k;
    }
}
