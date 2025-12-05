package com.leiqjl;

/**
 * 3432. Count Partitions with Even Sum Difference - Easy
 */
public class CountPartitionsWithEvenSumDifference {
    public int countPartitions(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return (sum & 1) == 0 ? nums.length - 1 : 0;
    }
}
