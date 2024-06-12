package com.leiqjl;

import java.util.Arrays;

/**
 * 75. Sort Colors - Medium
 */
public class SortColors {
    //Constraints:
    //
    //n == nums.length
    //1 <= n <= 300
    //nums[i] is either 0, 1, or 2.
    public void sortColors(int[] nums) {
        int zeroIdx = 0, twoIdx = nums.length - 1;
        int idx = 0;
        while (idx <= twoIdx) {
            if (nums[idx] == 0) {
                swap(nums, idx, zeroIdx);
                zeroIdx++;
                idx++;
            } else if (nums[idx] == 2) {
                swap(nums, idx, twoIdx);
                twoIdx--;
            } else {
                idx++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        SortColors sc = new SortColors();
        //Input: nums = [2,0,2,1,1,0]
        //Output: [0,0,1,1,2,2]
        int[] nums = {2, 0, 2, 1, 1, 0};
        sc.sortColors(nums);
        assert "[0, 0, 1, 1, 2, 2]".equals(Arrays.toString(nums));
        //Input: nums = [2,0,1]
        //Output: [0,1,2]
        int[] nums2 = {2, 0, 1,};
        sc.sortColors(nums2);
        assert "[0, 1, 2]".equals(Arrays.toString(nums2));
    }
}
