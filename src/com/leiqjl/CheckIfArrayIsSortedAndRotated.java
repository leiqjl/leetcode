package com.leiqjl;

/**
 * 1752. Check if Array Is Sorted and Rotated - Easy
 */
public class CheckIfArrayIsSortedAndRotated {
    public boolean check(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                count++;
            }
        }
        if (nums[0] < nums[nums.length - 1]) {
            count++;
        }
        return count <= 1;
    }
}
