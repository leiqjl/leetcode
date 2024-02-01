package com.leiqjl;

import java.util.Arrays;

/**
 * 2966. Divide Array Into Arrays With Max Difference - Medium
 */
public class DivideArrayIntoArraysWithMaxDifference {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int[][] ans = new int[nums.length / 3][3];
        int idx = 0;
        for (int i = 0; i < nums.length; i += 3) {
            if ((nums[i + 2] - nums[i]) > k) {
                return new int[0][0];
            }
            ans[idx++] = new int[]{nums[i], nums[i + 1], nums[i + 2]};
        }
        return ans;
    }
}
