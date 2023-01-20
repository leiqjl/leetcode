package com.leiqjl;

/**
 * 918. Maximum Sum Circular Subarray - Medium
 */
public class MaximumSumCircularSubarray {
    public int maxSubarraySumCircular(int[] nums) {
        int curMax = 0, maxSum = Integer.MIN_VALUE, curMin = 0, minSum = Integer.MAX_VALUE, total = 0;
        for (int num : nums) {
            curMax = Math.max(curMax + num, num);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(curMin + num, num);
            minSum = Math.min(minSum, curMin);
            total = total + num;
        }
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }
}
