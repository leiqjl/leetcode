package com.leiqjl;

import java.util.Arrays;

/**
 * 2779. Maximum Beauty of an Array After Applying Operation - Medium
 */
public class MaximumBeautyOfAnArrayAfterApplyingOperation {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int max = 0, l = 0, r = 0;
        while (l < nums.length) {
            while (r < nums.length && nums[r] - nums[l] <= k * 2) {
                r++;
            }
            max = Math.max(max, r - l);
            l++;
        }
        return max;
    }
}
