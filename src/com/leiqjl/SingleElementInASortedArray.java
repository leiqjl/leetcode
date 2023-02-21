package com.leiqjl;

/**
 * 540. Single Element in a Sorted Array - Medium
 * You are given a sorted array consisting of only integers where every element appears exactly twice,
 * except for one element which appears exactly once.
 * <p>
 * Return the single element that appears only once.
 * <p>
 * Your solution must run in O(log n) time and O(1) space.
 */
public class SingleElementInASortedArray {
    //Constraints:
    //
    //1 <= nums.length <= 10^5
    //0 <= nums[i] <= 10^5
    public int singleNonDuplicate(int[] nums) {
        int nonDuplicate = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nonDuplicate ^= nums[i];
        }
        return nonDuplicate;
    }

    public static void main(String[] args) {
        SingleElementInASortedArray s = new SingleElementInASortedArray();
        assert s.singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}) == 2;
        assert s.singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}) == 10;
    }
}
