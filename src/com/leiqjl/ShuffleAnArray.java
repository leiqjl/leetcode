package com.leiqjl;

import java.util.Random;

/**
 * 384. Shuffle an Array - Medium
 */
public class ShuffleAnArray {
    class Solution {
        private int[] arr;
        Random random = new Random();
        public Solution(int[] nums) {
            arr = nums;
        }

        public int[] reset() {
            return arr;
        }

        public int[] shuffle() {
            int[] nums = arr.clone();
            for (int i = 1; i < nums.length; i++) {
                int j = random.nextInt(i+1);
                swap(nums, i, j);
            }
            return nums;
        }
        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
