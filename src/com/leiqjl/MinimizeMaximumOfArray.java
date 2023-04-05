package com.leiqjl;

/**
 * 2439. Minimize Maximum of Array - Medium
 */
public class MinimizeMaximumOfArray {
    public int minimizeArrayValue(int[] nums) {
        long result = 0, curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            result = Math.max(result, (curSum + i) / (i + 1));
        }
        return (int) result;
    }

    public static void main(String[] args) {
        MinimizeMaximumOfArray m = new MinimizeMaximumOfArray();
        assert m.minimizeArrayValue(new int[]{3, 7, 1, 6}) == 5;
        assert m.minimizeArrayValue(new int[]{10, 1}) == 10;
    }
}
