package com.leiqjl;

/**
 * 3191. Minimum Operations to Make Binary Array Elements Equal to One I - Medium
 * You are given a binary array nums.
 * <p>
 * You can do the following operation on the array any number of times (possibly zero):
 * <p>
 * ·Choose any 3 consecutive elements from the array and flip all of them.
 * Flipping an element means changing its value from 0 to 1, and from 1 to 0.
 * <p>
 * Return the minimum number of operations required to make all elements in nums equal to 1. If it is impossible, return -1.
 */
public class MinimumOperationsToMakeBinaryArrayElementsEqualToOneI {
    //left most 0 -> 1
    public int minOperations(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (i >= nums.length - 2) {
                    return -1;
                }
                nums[i] = 1;
                nums[i + 1] = 1 - nums[i + 1];
                nums[i + 2] = 1 - nums[i + 2];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MinimumOperationsToMakeBinaryArrayElementsEqualToOneI m = new MinimumOperationsToMakeBinaryArrayElementsEqualToOneI();
        assert m.minOperations(new int[]{0, 1, 1, 1, 0, 0}) == 3;
        assert m.minOperations(new int[]{0, 1, 1, 1}) == -1;
        assert m.minOperations(new int[]{1, 1, 1, 1, 1}) == 0;
        assert m.minOperations(new int[]{1, 0, 0, 1, 0, 1, 1, 0}) == -1;
        assert m.minOperations(new int[]{1, 0, 0, 0, 0, 0, 1, 1}) == -1;
    }
}
