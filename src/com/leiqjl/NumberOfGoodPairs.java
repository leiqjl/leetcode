package com.leiqjl;

/**
 * 1512. Number of Good Pairs - Easy
 */
public class NumberOfGoodPairs {
    public int numIdenticalPairs(int[] nums) {
        int res = 0;
        int[] count = new int[101];
        for (int num : nums) {
            res += count[num];
            count[num]++;
        }
        return res;
    }
}
