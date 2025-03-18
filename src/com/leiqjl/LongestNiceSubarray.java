package com.leiqjl;

/**
 * 2401. Longest Nice Subarray - Medium
 * You are given an array nums consisting of positive integers.
 * <p>
 * We call a subarray of nums nice if the bitwise AND of every pair of elements that are in different positions in the subarray is equal to 0.
 * <p>
 * Return the length of the longest nice subarray.
 * <p>
 * A subarray is a contiguous part of an array.
 * <p>
 * Note that subarrays of length 1 are always considered nice.
 */
public class LongestNiceSubarray {
    public int longestNiceSubarray(int[] nums) {
        int start = 0, end = 0, cur = 0, maxLen = 0;
        while (end < nums.length) {
            while ((cur & nums[end]) != 0) {
                cur ^= nums[start];
                start++;
            }
            cur |= nums[end];
            end++;
            maxLen = Math.max(maxLen, end - start);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestNiceSubarray l = new LongestNiceSubarray();
        assert l.longestNiceSubarray(new int[]{1, 3, 8, 48, 10}) == 3;
        assert l.longestNiceSubarray(new int[]{3, 1, 5, 11, 13}) == 1;
        assert l.longestNiceSubarray(new int[]{84139415, 693324769, 614626365, 497710833, 615598711, 264, 65552, 50331652, 1, 1048576, 16384, 544, 270532608, 151813349, 221976871, 678178917, 845710321, 751376227, 331656525, 739558112, 267703680}) == 8;
    }
}
