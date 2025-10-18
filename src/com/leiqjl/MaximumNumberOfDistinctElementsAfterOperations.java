package com.leiqjl;

import java.util.Arrays;

/**
 * 3397. Maximum Number of Distinct Elements After Operations - Medium
 */
public class MaximumNumberOfDistinctElementsAfterOperations {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int prev = Integer.MIN_VALUE;
        int ans = 0;
        for (int num : nums) {
            int cur = Math.min(Math.max(prev + 1, num - k), num + k);
            if (cur > prev) {
                prev = cur;
                ans++;
            }
        }
        return ans;
    }
}
