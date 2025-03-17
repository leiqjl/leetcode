package com.leiqjl;


import java.util.Arrays;

/**
 * 3107. Minimum Operations to Make Median of Array Equal to K - Medium
 * You are given an integer array nums and a non-negative integer k. In one operation, you can increase or decrease any element by 1.
 * <p>
 * Return the minimum number of operations needed to make the median of nums equal to k.
 * <p>
 * The median of an array is defined as the middle element of the array when it is sorted in non-decreasing order. If there are two choices for a median, the larger of the two values is taken.
 */
public class MinimumOperationsToMakeMedianOfArrayEqualToK {
    //0 1 2 3 4
    //0 1 2 3 4 5
    public long minOperationsToMakeMedianK(int[] nums, int k) {
        Arrays.sort(nums);
        int index = nums.length / 2;
        long count = 0;
        if (nums[index] == k) {
            return count;
        } else if (nums[index] > k) {
            for (int i = index; i >= 0; i--) {
                if (nums[i] <= k) {
                    break;
                }
                count += (nums[i] - k);
            }
        } else {
            for (int i = index; i < nums.length; i++) {
                if (nums[i] >= k) {
                    break;
                }
                count += (k - nums[i]);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MinimumOperationsToMakeMedianOfArrayEqualToK m = new MinimumOperationsToMakeMedianOfArrayEqualToK();
        //2, 5, 5, 6, 8
        //2, 4, 4, 6, 8
        assert m.minOperationsToMakeMedianK(new int[]{2, 5, 6, 8, 5}, 4) == 2;
        //2, 5, 7, 7, 8
        assert m.minOperationsToMakeMedianK(new int[]{2, 5, 6, 8, 5}, 7) == 3;
        assert m.minOperationsToMakeMedianK(new int[]{1, 2, 3, 4, 5, 6}, 4) == 0;
    }
}
