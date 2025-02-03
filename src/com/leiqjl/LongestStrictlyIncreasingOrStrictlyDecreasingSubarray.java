package com.leiqjl;

/**
 * 3105. Longest Strictly Increasing or Strictly Decreasing Subarray - Easy
 */
public class LongestStrictlyIncreasingOrStrictlyDecreasingSubarray {
    public int longestMonotonicSubarray(int[] nums) {
        int maxLength = 1;
        int increasingLength = 1;
        int decreasingLength = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                increasingLength++;
                decreasingLength = 1;
            } else if (nums[i] < nums[i-1]) {
                decreasingLength++;
                increasingLength = 1;
            } else {
                increasingLength = 1;
                decreasingLength = 1;
            }
            maxLength = Math.max(maxLength, Math.max(increasingLength, decreasingLength));
        }
        return maxLength;
    }
}
