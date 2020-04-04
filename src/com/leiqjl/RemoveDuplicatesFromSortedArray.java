package com.leiqjl;

/**
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int s = 0;
        int q = 1;
        while (q < nums.length) {
            if (nums[s] < nums[q]) {
                nums[++s] = nums[q++];
            } else {
                q++;
            }
        }
        return s+1;
    }

}
