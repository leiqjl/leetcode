package com.leiqjl;

/**
 * 643. Maximum Average Subarray I - Easy
 * You are given an integer array nums consisting of n elements, and an integer k.
 * <p>
 * Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10……-5 will be accepted.
 */
public class MaximumAverageSubarrayI {
    //Constraints:
    //
    //n == nums.length
    //1 <= k <= n <= 10^5
    //-10^4 <= nums[i] <= 10^4
    public double findMaxAverage(int[] nums, int k) {
        int max = Integer.MIN_VALUE, cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i >= k) {
                cur -= nums[i - k];
            }
            cur += nums[i];
            if (i >= k - 1) {
                max = Math.max(max, cur);
            }
        }
        return max * 1.0 / k;
    }

    public static void main(String[] args) {
        MaximumAverageSubarrayI m = new MaximumAverageSubarrayI();
        assert m.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4) == 12.75;
        assert m.findMaxAverage(new int[]{5}, 1) == 5;
        assert m.findMaxAverage(new int[]{-1}, 1) == -1.0;
    }
}
