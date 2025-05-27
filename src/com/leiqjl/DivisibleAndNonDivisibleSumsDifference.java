package com.leiqjl;

/**
 * 2894. Divisible and Non-divisible Sums Difference - Easy
 */
public class DivisibleAndNonDivisibleSumsDifference {
    // nums2 = (1+2+...+n/m)*m
    // nums1 = (1+2+...+n)-nums2
    public int differenceOfSums(int n, int m) {
        int k = n / m;
        return (n * (n + 1)) / 2 - 2 * m * (k * (k + 1)) / 2;
    }
}
