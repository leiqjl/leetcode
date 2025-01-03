package com.leiqjl;

/**
 * 2270. Number of Ways to Split Array - Medium
 */
public class NumberOfWaysToSplitArray {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int res = 0;
        long curSum = 0;
        for (int i = 0; i < n - 1; i++) {
            curSum += nums[i];
            sum -= nums[i];
            if (curSum >= sum) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        NumberOfWaysToSplitArray n = new NumberOfWaysToSplitArray();
        assert n.waysToSplitArray(new int[]{10, 4, -8, 7}) == 2;
        assert n.waysToSplitArray(new int[]{2, 3, 1, 0}) == 2;
    }
}
