package com.leiqjl;

import java.util.Arrays;

/**
 * 2616. Minimize the Maximum Difference of Pairs - Medium
 */
public class MinimizeTheMaximumDifferenceOfPairs {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int left = 0, right = nums[nums.length - 1] - nums[0];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (countPairs(nums, mid) >= p) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int countPairs(int[] nums, int target) {
        int i = 0;
        int count = 0;
        while (i < nums.length - 1) {
            if (nums[i + 1] - nums[i] <= target) {
                i += 2;
                count++;
            } else {
                i++;
            }
        }
        return count;
    }
}
