package com.leiqjl;

/**
 * 645. Set Mismatch
 * <p>
 * You have a set of integers s, which originally contains all the numbers from 1 to n.
 * Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set,
 * which results in repetition of one number and loss of another number.
 * <p>
 * You are given an integer array nums representing the data status of this set after the error.
 * <p>
 * Find the number that occurs twice and the number that is missing and return them in the form of an array.
 */
public class SetMismatch {

    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        for (int num : nums) {
            if (nums[Math.abs(num) - 1] < 0) {
                result[0] = Math.abs(num);
            } else {
                nums[Math.abs(num) - 1] *= -1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result[1] = i + 1;
            } else {
                nums[i] *= -1;
            }
        }
        return result;
    }
}
