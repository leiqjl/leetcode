package com.leiqjl;

/**
 * 410. Split Array Largest Sum - Hard
 */
public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int k) {
        int left = 0, right = 0;
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }
        while (left < right) {
            int mid = (left + right) / 2;
            int count = 1, sum = 0;
            for (int num : nums) {
                if (sum + num > mid) {
                    sum = 0;
                    count++;
                }
                sum += num;
            }
            if (count > k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
