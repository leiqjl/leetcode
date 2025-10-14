package com.leiqjl;

import java.util.Arrays;
import java.util.List;

/**
 * 3349. Adjacent Increasing Subarrays Detection I - Easy
 * Given an array nums of n integers and an integer k, determine whether there exist two adjacent subarrays of length k such that both subarrays are strictly increasing. Specifically, check if there are two subarrays starting at indices a and b (a < b), where:
 * <p>
 * - Both subarrays nums[a..a + k - 1] and nums[b..b + k - 1] are strictly increasing.
 * - The subarrays must be adjacent, meaning b = a + k.
 * Return true if it is possible to find two such subarrays, and false otherwise.
 */
public class AdjacentIncreasingSubarraysDetectionI {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        int cur = 1, pre = 0, max = 0;
        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                cur++;
            } else {
                pre = cur;
                cur = 1;
            }
            max = Math.max(max, Math.max(Math.min(pre, cur), cur / 2));
        }
        return max >= k;
    }

    public boolean hasIncreasingSubarrays1(List<Integer> nums, int k) {
        int n = nums.size();
        int i = 0;
        while (i <= n - k * 2) {
            int firstEnd = checkStrictlyIncreasing(nums, i, i + k);
            if (firstEnd < i + k) {
                i = firstEnd;
                continue;
            }

            int secondEnd = checkStrictlyIncreasing(nums, i + k, i + k * 2);
            if (secondEnd == i + k * 2) {
                return true;
            } else {
                i = secondEnd - k;
            }
        }
        return false;
    }

    private int checkStrictlyIncreasing(List<Integer> nums, int start, int end) {
        for (int i = start + 1; i < end; i++) {
            if (nums.get(i) <= nums.get(i - 1)) {
                return i;
            }
        }
        return end;
    }

    public static void main(String[] args) {
        AdjacentIncreasingSubarraysDetectionI a = new AdjacentIncreasingSubarraysDetectionI();
        //Input: nums = [2,5,7,8,9,2,3,4,3,1], k = 3
        //Output: true
        assert a.hasIncreasingSubarrays(Arrays.asList(2, 5, 7, 8, 9, 2, 3, 4, 3, 1), 3);
        //Input: nums = [1,2,3,4,4,4,4,5,6,7], k = 5
        //Output: false
        assert !a.hasIncreasingSubarrays(Arrays.asList(1, 2, 3, 4, 4, 4, 4, 5, 6, 7), 5);

        assert a.hasIncreasingSubarrays(Arrays.asList(2, 5, 7, 8, 9, 5, 3, 4, 5, 1, 2, 3), 3);
    }
}
