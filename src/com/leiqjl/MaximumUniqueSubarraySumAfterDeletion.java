package com.leiqjl;

/**
 * 3487. Maximum Unique Subarray Sum After Deletion - Easy
 */
public class MaximumUniqueSubarraySumAfterDeletion {
    public int maxSum(int[] nums) {
        boolean[] arr = new boolean[101];
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > 0) {
                arr[num] = true;
            }
            max = Math.max(num, max);
        }

        for (int i = max - 1; i > 0; i--) {
            if (arr[i]) {
                max += i;
            }
        }
        return max;
    }
}
