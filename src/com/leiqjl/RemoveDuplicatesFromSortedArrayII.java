package com.leiqjl;

/**
 * 80. Remove Duplicates from Sorted Array II - Medium
 */
public class RemoveDuplicatesFromSortedArrayII {
    //Constraints:
    //1 <= nums.length <= 3 * 10^4
    //-10^4 <= nums[i] <= 10^4
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int idx = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[idx - 2]) {
                nums[idx++] = nums[i];
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArrayII removeDuplicates = new RemoveDuplicatesFromSortedArrayII();
        assert removeDuplicates.removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}) == 5;
        assert removeDuplicates.removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}) == 7;
    }
}
