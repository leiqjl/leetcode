package com.leiqjl;

/**
 * 2419. Longest Subarray With Maximum Bitwise AND - Medium
 * You are given an integer array nums of size n.
 * <p>
 * Consider a non-empty subarray from nums that has the maximum possible bitwise AND.
 * <p>
 * ·In other words, let k be the maximum value of the bitwise AND of any subarray of nums. Then, only subarrays with a bitwise AND equal to k should be considered.
 * Return the length of the longest such subarray.
 * <p>
 * The bitwise AND of an array is the bitwise AND of all the numbers in it.
 * <p>
 * A subarray is a contiguous sequence of elements within an array.
 */
public class LongestSubarrayWithMaximumBitwiseAND {
    public int longestSubarray(int[] nums) {
        int max = Integer.MIN_VALUE, len = 0, maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
                len = 0;
                maxLen = 0;
            }
            if (max == nums[i]) {
                len++;
            } else {
                len = 0;
            }
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubarrayWithMaximumBitwiseAND l = new LongestSubarrayWithMaximumBitwiseAND();
        assert l.longestSubarray(new int[]{1, 2, 3, 3, 2, 2}) == 2;
        assert l.longestSubarray(new int[]{1, 2, 3, 4}) == 1;
        assert l.longestSubarray(new int[]{1, 2, 3, 3, 2, 5}) == 1;
        assert l.longestSubarray(new int[]{1, 2, 3, 3, 2, 2, 3, 3, 3}) == 3;
    }
}
