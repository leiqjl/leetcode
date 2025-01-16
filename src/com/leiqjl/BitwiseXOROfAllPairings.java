package com.leiqjl;

/**
 * 2425. Bitwise XOR of All Pairings - Medium
 * You are given two 0-indexed arrays, nums1 and nums2, consisting of non-negative integers.
 * There exists another array, nums3, which contains the bitwise XOR of all pairings of integers between nums1 and nums2 (every integer in nums1 is paired with every integer in nums2 exactly once).
 * <p>
 * Return the bitwise XOR of all integers in nums3.
 */
public class BitwiseXOROfAllPairings {

    public int xorAllNums(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int res = 0;
        if ((len1 & 1) == 1) {
            for (int num : nums2) {
                res ^= num;
            }
        }
        if ((len2 & 1) == 1) {
            for (int num : nums1) {
                res ^= num;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        BitwiseXOROfAllPairings b = new BitwiseXOROfAllPairings();
        assert b.xorAllNums(new int[]{2, 1, 3}, new int[]{10, 2, 5, 0}) == 13;
        assert b.xorAllNums(new int[]{1, 2}, new int[]{3, 4}) == 0;
    }
}
