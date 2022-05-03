package com.leiqjl;

/**
 * 581. Shortest Unsorted Continuous Subarray - Medium
 */
public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int l = 0, r = nums.length - 1;
        int begin = -1, end = -1;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        while (r >= 0) {
            if (nums[l] >= max) {
                max = nums[l];
            } else {
                end = l;
            }
            if (nums[r] <= min) {
                min = nums[r];
            } else {
                begin = r;
            }
            l++;
            r--;
        }
        return end == -1 ? 0 : end - begin + 1;
    }
}
