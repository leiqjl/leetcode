package com.leiqjl;

import java.util.HashSet;

/**
 * 3375. Minimum Operations to Make Array Values Equal to K - Easy
 */
public class MinimumOperationsToMakeArrayValuesEqualToK {
    public int minOperations(int[] nums, int k) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (num > k) {
                hashSet.add(num);
            } else if (num < k) {
                return 0;
            }
        }
        return hashSet.size();
    }
}
