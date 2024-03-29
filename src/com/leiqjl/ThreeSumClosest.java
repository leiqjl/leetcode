package com.leiqjl;

import java.util.Arrays;

/**
 * 16. 3Sum Closest - Medium
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 * <p>
 * Example:
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {

        if (nums == null || nums.length < 3) {
            return -1;
        }

        Arrays.sort(nums);
        int n = nums.length;
        int firstThree = nums[0] + nums[1] + nums[2];
        int lastThree = nums[n - 1] + nums[n - 2] + nums[n - 3];
        if (target < firstThree) {
            return firstThree;
        }
        if (target > lastThree) {
            return lastThree;
        }
        int result = firstThree;
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int l = i + 1;
            int r = n - 1;
            while (l < r) {

                int sum = nums[i] + nums[l] + nums[r];
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }

                if (sum < target) {
                    l++;
                } else if (sum > target) {
                    r--;
                } else {
                    return target;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ThreeSumClosest t = new ThreeSumClosest();
        int[] nums = {-1, 2, 1, -4};
        assert t.threeSumClosest(nums, 1) == 2;
        assert t.threeSumClosest(new int[]{0, 0, 0}, 1) == 0;
    }
}
