package com.leiqjl;

/**
 * 2560. House Robber IV - Medium
 */
public class HouseRobberIV {
    public int minCapability(int[] nums, int k) {
        int right = 0, left = 1;
        for (int num : nums) {
            right = Math.max(num, right);
        }
        while (left < right) {
            int mid = (left + right) / 2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;
                    i++;
                }
            }
            if (count >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
