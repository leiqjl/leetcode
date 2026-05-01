package com.leiqjl;

/**
 * 396. Rotate Function - Medium
 * You are given an integer array nums of length n.
 * <p>
 * Assume arrk to be an array obtained by rotating nums by k positions clock-wise. We define the rotation function F on nums as follow:
 * <p>
 * F(k) = 0 * arrk[0] + 1 * arrk[1] + ... + (n - 1) * arrk[n - 1].
 * Return the maximum value of F(0), F(1), ..., F(n-1).
 * <p>
 * The test cases are generated so that the answer fits in a 32-bit integer.
 */
public class RotateFunction {
    // f(0) = 0 * nums[0] + 1 * nums[1] + ... + (n - 1) * nums[n - 1]
    // f(1) = 0 * nums[n-1] + 1 * nums[0] + ... + (n - 1) * nums[n - 2] = f(0) + (sum(nums)-nums[n-1]) - (n - 1) * nums[n - 1] = f(0) + sum - n * nums[n - 1]
    // f(k) = f(k-1) + sum - n * nums[n - k]
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int val = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            val += i * nums[i];
        }
        int max = val;
        for (int i = n - 1; i > 0; i--) {
            val = val + sum - n * nums[i];
            max = Math.max(max, val);
        }
        return max;
    }

    public static void main(String[] args) {
        RotateFunction r = new RotateFunction();
        //Input: nums = [4,3,2,6]
        //Output: 26
        assert r.maxRotateFunction(new int[]{4, 3, 2, 6}) == 26;
        assert r.maxRotateFunction(new int[]{100}) == 0;
    }
}
