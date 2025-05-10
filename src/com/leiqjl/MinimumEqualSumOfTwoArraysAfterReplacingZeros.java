package com.leiqjl;

/**
 * 2918. Minimum Equal Sum of Two Arrays After Replacing Zeros - Medium
 */
public class MinimumEqualSumOfTwoArraysAfterReplacingZeros {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0, sum2 = 0;
        int zeroCount1 = 0, zeroCount2 = 0;
        for (int num : nums1) {
            sum1 += num;
            if (num == 0) {
                zeroCount1++;
            }
        }
        sum1 += zeroCount1;
        for (int num : nums2) {
            sum2 += num;
            if (num == 0) {
                zeroCount2++;
            }
        }
        sum2 += zeroCount2;
        if ((zeroCount1 == 0 && sum1 < sum2) || (zeroCount2 == 0 && sum2 < sum1)) {
            return -1;
        }
        return Math.max(sum1, sum2);
    }
}
