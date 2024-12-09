package com.leiqjl;

/**
 * 1760. Minimum Limit of Balls in a Bag - Medium
 */
public class MinimumLimitOfBallsInABag {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = 0;
        for (int num : nums) {
            right = Math.max(num, right);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(mid, nums, maxOperations)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int balls, int[] nums, int maxOperations) {
        int totalOpts = 0;
        for (int num : nums) {
            int opts = (num + balls - 1) / balls - 1;
            totalOpts += opts;
            if (totalOpts > maxOperations) {
                return false;
            }
        }
        return true;
    }
}
