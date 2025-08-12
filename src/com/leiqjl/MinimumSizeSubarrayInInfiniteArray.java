package com.leiqjl;

/**
 * 2875. Minimum Size Subarray in Infinite Array - Medium
 */
public class MinimumSizeSubarrayInInfiniteArray {
    public int minSizeSubarray(int[] nums, int target) {
        int n = nums.length;
        long sum = 0;
        int m = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum <= target) {
            m = (int) (target / sum);
            target %= sum;
        }
        if (target == 0) {
            return m * n;
        }
        int len = Integer.MAX_VALUE;
        int right = 0, left = 0;
        sum = 0;
        while (right < n * 2) {
            sum += nums[right % n];
            while (sum > target && left <= right) {
                sum -= nums[left % n];
                left++;
            }
            if (sum == target) {
                len = Math.min(len, right - left + 1);
            }
            right++;
        }
        return len == Integer.MAX_VALUE ? -1 : len + m * n;
    }

    public static void main(String[] args) {
        MinimumSizeSubarrayInInfiniteArray m = new MinimumSizeSubarrayInInfiniteArray();
        assert m.minSizeSubarray(new int[]{1, 2, 3}, 5) == 2;
        assert m.minSizeSubarray(new int[]{1, 1, 1, 2, 3}, 4) == 2;
        assert m.minSizeSubarray(new int[]{2, 4, 6, 8}, 3) == -1;
    }
}
