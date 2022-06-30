package com.leiqjl;

import java.util.Arrays;

/**
 * 462. Minimum Moves to Equal Array Elements II - Medium
 * <p>
 * Given an integer array nums of size n, return the minimum number of moves required to make all array elements equal.
 * <p>
 * In one move, you can increment or decrement an element of the array by 1.
 * <p>
 * Test cases are designed so that the answer will fit in a 32-bit integer.
 */
public class MinimumMovesToEqualArrayElementsII {

    // median
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int begin = 0, end = nums.length - 1;
        int count = 0;
        while (begin < end) {
            count += (nums[end] - nums[begin]);
            begin++;
            end--;
        }
        return count;
    }

    public static void main(String[] args) {
        MinimumMovesToEqualArrayElementsII m = new MinimumMovesToEqualArrayElementsII();
        //Input: nums = [1,2,3]
        //Output: 2
        //Explanation:
        //Only two moves are needed (remember each move increments or decrements one element):
        //[1,2,3]  =>  [2,2,3]  =>  [2,2,2]
        int[] nums = {1, 2, 3};
        assert m.minMoves2(nums) == 2;
        //Input: nums = [1,10,2,9]
        //Output: 16
        int[] nums1 = {1, 10, 2, 9};
        assert m.minMoves2(nums1) == 16;

        int[] nums2 = {1, 0, 0, 8, 6};
        // 3 3 3 8 6 8
        assert m.minMoves2(nums2) == 14;
    }
}
