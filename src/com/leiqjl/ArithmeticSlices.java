package com.leiqjl;

/**
 * 413. Arithmetic Slices - Medium
 * <p>
 * An integer array is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
 * <p>
 * - For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
 * Given an integer array nums, return the number of arithmetic subarrays of nums.
 * <p>
 * A subarray is a contiguous subsequence of the array.
 */
public class ArithmeticSlices {

    public int numberOfArithmeticSlices(int[] nums) {
        int result = 0, count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if ((nums[i + 1] - nums[i]) == (nums[i + 2] - nums[i + 1])) {
                count++;
                result += count;
            } else {
                count = 0;
            }
        }
        return result;
    }
}
