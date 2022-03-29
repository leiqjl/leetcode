package com.leiqjl;

/**
 * 303. Range Sum Query - Immutable  - Easy
 */
public class RangeSumQuery_Immutable {
    class NumArray {
        int[] sums;

        public NumArray(int[] nums) {
            this.sums = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                sums[i + 1] = nums[i] + sums[i];
            }
        }

        public int sumRange(int left, int right) {
            return sums[right + 1] - sums[left];
        }
    }
}