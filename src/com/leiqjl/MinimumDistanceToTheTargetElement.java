package com.leiqjl;

/**
 * 1848. Minimum Distance to the Target Element - Easy
 */
public class MinimumDistanceToTheTargetElement {
    public int getMinDistance(int[] nums, int target, int start) {
        int min = Integer.MAX_VALUE;
        for (int i = start; i < nums.length; i++) {
            if (nums[i] == target) {
                min = Math.min(min, i - start);
            }
        }
        for (int i = start - 1; i >= 0; i--) {
            if (nums[i] == target) {
                min = Math.min(min, start - i);
            }
        }
        return min;
    }
}
