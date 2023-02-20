package com.leiqjl;

/**
 * 2239. Find Closest Number to Zero - Easy
 */
public class FindClosestNumberToZero {
    public int findClosestNumber(int[] nums) {
        int result = Integer.MAX_VALUE;
        for (int num : nums) {
            if (Math.abs(num) < Math.abs(result) || num == Math.abs(result)) {
                result = num;
            }
        }
        return result;
    }
}
