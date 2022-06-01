package com.leiqjl;

/**
 * 1480. Running Sum of 1d Array - Easy
 * <p>
 * Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
 * <p>
 * Return the running sum of nums.
 */
public class RunningSumOf1dArray {

    public int[] runningSum(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }
        return nums;
    }

}
