package com.leiqjl;

import java.util.Arrays;

/**
 * 3727. Maximum Alternating Sum of Squares - Medium
 */
public class MaximumAlternatingSumOfSquares {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long res = 0;
        for (int i = 0; i < n; i++) {
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);
        for (int i = n / 2; i < n; i++) {
            res += nums[i];
        }
        for (int i = 0; i < n / 2; i++) {
            res -= nums[i];
        }
        return res;
    }
}
