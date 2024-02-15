package com.leiqjl;

import java.util.Arrays;

/**
 * 2971. Find Polygon With the Largest Perimeter - Medium
 */
public class FindPolygonWithTheLargestPerimeter {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long res = -1, preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i >= 2 && nums[i] < preSum) {
                res = nums[i] + preSum;
            }
            preSum += nums[i];
        }
        return res;
    }
}
