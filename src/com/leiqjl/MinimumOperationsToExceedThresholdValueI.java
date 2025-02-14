package com.leiqjl;

/**
 * 3065. Minimum Operations to Exceed Threshold Value I - Easy
 * You are given a 0-indexed integer array nums, and an integer k.
 * <p>
 * In one operation, you can remove one occurrence of the smallest element of nums.
 * <p>
 * Return the minimum number of operations needed so that all elements of the array are greater than or equal to k.
 */
public class MinimumOperationsToExceedThresholdValueI {
    //Constraints:
    //
    //1 <= nums.length <= 50
    //1 <= nums[i] <= 10^9
    //1 <= k <= 109
    //The input is generated such that there is at least one index i such that nums[i] >= k.
    public int minOperations(int[] nums, int k) {
        int count = 0;
        for (int num : nums) {
            if (num < k) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MinimumOperationsToExceedThresholdValueI m = new MinimumOperationsToExceedThresholdValueI();
        assert m.minOperations(new int[]{2, 11, 10, 1, 3}, 10) == 3;
        assert m.minOperations(new int[]{1, 1, 2, 4, 9}, 1) == 0;
        assert m.minOperations(new int[]{1, 1, 2, 4, 9}, 9) == 4;
    }
}
