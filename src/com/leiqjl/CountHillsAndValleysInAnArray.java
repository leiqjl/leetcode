package com.leiqjl;

/**
 * 2210. Count Hills and Valleys in an Array - Easy
 */
public class CountHillsAndValleysInAnArray {
    public int countHillValley(int[] nums) {
        int count = 0;
        int l = 0, r = 1;
        while (r < nums.length - 1) {
            if ((nums[l] < nums[r] && nums[r] > nums[r + 1])
                    || (nums[l] > nums[r] && nums[r] < nums[r + 1])) {
                count++;
                l = r;
            }
            r++;
        }
        return count;
    }

    public static void main(String[] args) {
        CountHillsAndValleysInAnArray c = new CountHillsAndValleysInAnArray();
        assert c.countHillValley(new int[]{2, 4, 1, 1, 6, 5}) == 3;
        assert c.countHillValley(new int[]{6, 6, 5, 5, 4, 1}) == 0;
    }
}
