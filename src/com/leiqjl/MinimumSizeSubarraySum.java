package com.leiqjl;

/**
 * 209. Minimum Size Subarray Sum - Medium
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target.
 * If there is no such subarray, return 0 instead.
 */
public class MinimumSizeSubarraySum {
    //Constraints:
    //
    //1 <= target <= 10^9
    //1 <= nums.length <= 10^5
    //1 <= nums[i] <= 10^4
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE, sum = 0;
        int l = 0, r = 0;
        while (r < nums.length) {
            sum += nums[r];
            while (sum >= target) {
                min = Math.min(min, r - l + 1);
                sum -= nums[l];
                l++;
            }
            r++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum m = new MinimumSizeSubarraySum();
        assert m.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}) == 2;
        assert m.minSubArrayLen(4, new int[]{1, 4, 4}) == 1;
        assert m.minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}) == 0;
    }
}
