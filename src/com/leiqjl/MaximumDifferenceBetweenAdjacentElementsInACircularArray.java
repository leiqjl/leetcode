package com.leiqjl;

/**
 * 3423. Maximum Difference Between Adjacent Elements in a Circular Array - Easy
 * Given a circular array nums, find the maximum absolute difference between adjacent elements.
 * <p>
 * Note: In a circular array, the first and last elements are adjacent.
 */
public class MaximumDifferenceBetweenAdjacentElementsInACircularArray {
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int max = Math.abs(nums[0] - nums[n - 1]);
        for (int i = 1; i < n; i++) {
            max = Math.max(max, Math.abs(nums[i] - nums[i - 1]));
        }
        return max;
    }
}
