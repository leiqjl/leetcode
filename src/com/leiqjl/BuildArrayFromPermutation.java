package com.leiqjl;

/**
 * 1920. Build Array from Permutation - Easy
 * Given a zero-based permutation nums (0-indexed), build an array ans of the same length where ans[i] = nums[nums[i]] for each 0 <= i < nums.length and return it.
 * <p>
 * A zero-based permutation nums is an array of distinct integers from 0 to nums.length - 1 (inclusive).
 */
public class BuildArrayFromPermutation {

    //Constraints:
    //
    //1 <= nums.length <= 1000
    //0 <= nums[i] < nums.length
    //The elements in nums are distinct.
    //Follow-up: Can you solve it without using an extra space (i.e., O(1) memory)?

    public int[] buildArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] += (nums[nums[i]] % nums.length) * nums.length;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] /= nums.length;
        }
        return nums;
    }
}
