package com.leiqjl;

import java.util.Arrays;

/**
 * 976. Largest Perimeter Triangle - Easy
 */
public class LargestPerimeterTriangle {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i] < nums[i - 1] + nums[i - 2]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }
        return -1;
    }
}
