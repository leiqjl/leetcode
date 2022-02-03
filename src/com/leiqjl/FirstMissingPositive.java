package com.leiqjl;

/**
 * 41. First Missing Positive
 * <p>
 * Given an unsorted integer array nums, return the smallest missing positive integer.
 * <p>
 * You must implement an algorithm that runs in O(n) time and uses constant extra space.
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int i;
        for (i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && (nums[nums[i] - 1] != nums[i])) {
                int a = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = a;
            }
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != (i + 1)) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
