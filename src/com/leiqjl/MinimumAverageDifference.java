package com.leiqjl;

/**
 * 2256. Minimum Average Difference - Medium
 */
public class MinimumAverageDifference {

    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int min = Integer.MAX_VALUE;
        int index = 0;
        long cur = 0;
        for (int i = 0; i < n; i++) {
            cur += nums[i];
            long left = cur / (i + 1);

            long right = sum - cur;
            if (i != n - 1) {
                right = right / (n - 1 - i);
            }
            int diff = (int) Math.abs(left - right);
            if (diff < min) {
                min = diff;
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        MinimumAverageDifference m = new MinimumAverageDifference();
        assert m.minimumAverageDifference(new int[]{2, 5, 3, 9, 5, 3}) == 3;
        assert m.minimumAverageDifference(new int[]{0, 0, 0, 0, 0}) == 0;
        assert m.minimumAverageDifference(new int[]{4, 2, 0}) == 2;
    }
}
