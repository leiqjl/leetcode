package com.leiqjl;

/**
 * 2348. Number of Zero-Filled Subarrays - Medium
 * Given an integer array nums, return the number of subarrays filled with 0.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 *
 */
public class NumberOfZeroFilledSubarrays {
    public long zeroFilledSubarray(int[] nums) {
        long result = 0;
        int subarrayCount = 0;
        for (int num : nums) {
            if (num == 0) {
                subarrayCount++;
            } else {
                subarrayCount = 0;
            }
            result += subarrayCount;
        }
        return result;
    }
}
