package com.leiqjl;

import java.util.Arrays;

/**
 * 503. Next Greater Element II - Medium
 */
public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        int[] stack = new int[n];
        int idx = -1;
        for (int i = 0; i < n * 2; i++) {
            while (idx > -1 && nums[i % n] > nums[stack[idx]]) {
                result[stack[idx--]] = nums[i % n];
            }
            if (i < n) {
                stack[++idx] = i;
            }
        }
        return result;
    }
}
