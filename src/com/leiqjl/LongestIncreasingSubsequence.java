package com.leiqjl;

/**
 * 300. Longest Increasing Subsequence - Medium
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int len = 0;
        for (int i = 0; i < n; i++) {
            int index = binarySearch(dp, 0, len, nums[i]);
            dp[index] = nums[i];
            if (index == len) {
                len++;
            }
        }
        return len;
    }
    private int binarySearch(int[] a, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) >>> 1;
            int midVal = a[mid];

            if (midVal < target)
                left = mid + 1;
            else if (midVal > target)
                right = mid - 1;
            else
                return mid;
        }
        return left;
    }

}
