package com.leiqjl;

import java.util.Arrays;

/**
 * 2563. Count the Number of Fair Pairs - Medium
 * Given a 0-indexed integer array nums of size n and two integers lower and upper, return the number of fair pairs.
 * <p>
 * A pair (i, j) is fair if:
 * <p>
 * ·0 <= i < j < n, and
 * ·lower <= nums[i] + nums[j] <= upper
 */
public class CountTheNumberOfFairPairs {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ltLower = countPairsLessThan(nums, lower);
        long leUpper = countPairsLessThan(nums, upper + 1);
        return leUpper - ltLower;
    }

    private long countPairsLessThan(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        long count = 0;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) {
                count += (right - left);
                left++;
            } else {
                right--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountTheNumberOfFairPairs c = new CountTheNumberOfFairPairs();
        //There are 6 fair pairs: (0,3), (0,4), (0,5), (1,3), (1,4), and (1,5).
        assert c.countFairPairs(new int[]{0, 1, 7, 4, 4, 5}, 3, 6) == 6;
        assert c.countFairPairs(new int[]{1, 7, 9, 2, 5}, 11, 11) == 1;
    }
}
