package com.leiqjl;

import java.util.Arrays;
import java.util.List;

/**
 * 3350. Adjacent Increasing Subarrays Detection II - Medium
 * GGiven an array nums of n integers, your task is to find the maximum value of k for which there exist two adjacent subarrays of length k each, such that both subarrays are strictly increasing. Specifically, check if there are two subarrays of length k starting at indices a and b (a < b), where:
 * <p>
 * - Both subarrays nums[a..a + k - 1] and nums[b..b + k - 1] are strictly increasing.
 * - The subarrays must be adjacent, meaning b = a + k.
 * Return the maximum possible value of k.
 * <p>
 * A subarray is a contiguous non-empty sequence of elements within an array.
 */
public class AdjacentIncreasingSubarraysDetectionII {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int cur = 1, pre = 0, max = 0;
        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                cur++;
            } else {
                pre = cur;
                cur = 1;
            }
            max = Math.max(max, Math.max(Math.min(pre, cur), cur / 2));
        }
        return max;
    }

    public static void main(String[] args) {
        AdjacentIncreasingSubarraysDetectionII a = new AdjacentIncreasingSubarraysDetectionII();
        assert a.maxIncreasingSubarrays(Arrays.asList(2, 5, 7, 8, 9, 2, 3, 4, 3, 1)) == 3;
        assert a.maxIncreasingSubarrays(Arrays.asList(1, 2, 3, 4, 4, 4, 4, 5, 6, 7)) == 2;
    }
}
