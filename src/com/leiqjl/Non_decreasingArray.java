package com.leiqjl;

/**
 * 665. Non-decreasing Array - Medium
 */
public class Non_decreasingArray {

    public boolean checkPossibility(int[] nums) {
        boolean modified = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                if (modified) {
                    return false;
                }
                modified = true;
                if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
                    nums[i] = nums[i - 1];
                } else {
                    nums[i - 1] = nums[i];
                }
            }
        }
        return true;
    }

}
