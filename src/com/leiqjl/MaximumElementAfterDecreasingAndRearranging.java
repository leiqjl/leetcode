package com.leiqjl;

/**
 * 1846. Maximum Element After Decreasing and Rearranging - Medium
 */
public class MaximumElementAfterDecreasingAndRearranging {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        int[] freq = new int[n + 1];
        for (int num : arr) {
            freq[Math.min(num, n)]++;
        }
        int ans = 1;
        for (int i = 2; i <= n; i++) {
            ans = Math.min(ans + freq[i], i);
        }
        return ans;
    }
}
