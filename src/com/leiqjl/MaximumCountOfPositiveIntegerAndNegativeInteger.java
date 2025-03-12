package com.leiqjl;

/**
 * 2529. Maximum Count of Positive Integer and Negative Integer - Easy
 * <p>
 * Given an array nums sorted in non-decreasing order, return the maximum between the number of positive integers and the number of negative integers.
 * <p>
 * ·In other words, if the number of positive integers in nums is pos and the number of negative integers is neg, then return the maximum of pos and neg.
 * <p>
 * Note that 0 is neither positive nor negative.
 */
public class MaximumCountOfPositiveIntegerAndNegativeInteger {
    public int maximumCount(int[] nums) {
        int pos = 0, neg = 0;
        for (int num : nums) {
            if (num > 0) {
                pos++;
            } else if (num < 0) {
                neg++;
            }
        }
        return Math.max(pos, neg);
    }
}
