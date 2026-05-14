package com.leiqjl;

/**
 * 2834. Check if Array Is Good - Easy
 */
public class CheckIfArrayIsGood {
    public boolean isGood(int[] nums) {
        int n = nums.length;
        int[] freq = new int[n];
        for (int num : nums) {
            if (num >= n) {
                return false;
            }
            if (num == n - 1 && freq[num] > 1) {
                return false;
            }
            if (num < n - 1 && freq[num] > 0) {
                return false;
            }
            freq[num]++;
        }
        return true;
    }
}
