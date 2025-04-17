package com.leiqjl;

/**
 * 2176. Count Equal and Divisible Pairs in an Array - Easy
 * Given a 0-indexed integer array nums of length n and an integer k, return the number of pairs (i, j) where 0 <= i < j < n, such that nums[i] == nums[j] and (i * j) is divisible by k.
 */
public class CountEqualAndDivisiblePairsInAnArray {
    //Constraints:
    //
    //1 <= nums.length <= 100
    //1 <= nums[i], k <= 100
    public int countPairs(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] == nums[j] && (i * j) % k == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountEqualAndDivisiblePairsInAnArray c = new CountEqualAndDivisiblePairsInAnArray();
        assert c.countPairs(new int[]{3, 1, 2, 2, 2, 1, 3}, 2) == 4;
        assert c.countPairs(new int[]{1, 2, 3, 4}, 1) == 0;
    }
}
