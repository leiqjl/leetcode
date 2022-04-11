package com.leiqjl;

import java.util.HashMap;

/**
 * 560. Subarray Sum Equals K - Medium
 * <p>
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 */
public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            count = count + map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
