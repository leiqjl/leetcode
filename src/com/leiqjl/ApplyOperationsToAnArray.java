package com.leiqjl;

/**
 * 2460. Apply Operations to an Array - Easy
 */
public class ApplyOperationsToAnArray {
    public int[] applyOperations(int[] nums) {
        int index = 0, i = 0;
        while (i < nums.length) {
            if (i < (nums.length - 1) && nums[i] == nums[i + 1] && nums[i] != 0) {
                nums[index++] = nums[i] * 2;
                i = i + 2;
            } else if (nums[i] == 0) {
                i++;
            } else {
                nums[index++] = nums[i++];
            }
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
        return nums;
    }
}
