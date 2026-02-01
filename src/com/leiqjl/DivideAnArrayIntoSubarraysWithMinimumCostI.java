package com.leiqjl;

/**
 * 3010. Divide an Array Into Subarrays With Minimum Cost I - Easy
 */
public class DivideAnArrayIntoSubarraysWithMinimumCostI {
    public int minimumCost(int[] nums) {
        int a = Math.min(nums[1], nums[2]);
        int b = Math.max(nums[1], nums[2]);
        for (int i = 3; i < nums.length; i++) {
            if (nums[i] < a) {
                b = a;
                a = nums[i];
            } else if (nums[i] < b) {
                b = nums[i];
            }
        }
        return nums[0] + a + b;
    }
}
