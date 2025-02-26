package com.leiqjl;

/**
 * 1749. Maximum Absolute Sum of Any Subarray - Medium
 */
public class MaximumAbsoluteSumOfAnySubarray {

    public int maxAbsoluteSum(int[] nums) {
        int maxPrefix = 0, minPrefix = 0, curPrefix = 0;
        for (int num : nums) {
            curPrefix += num;
            maxPrefix = Math.max(maxPrefix, curPrefix);
            minPrefix = Math.min(minPrefix, curPrefix);
        }
        return maxPrefix - minPrefix;
    }
}
