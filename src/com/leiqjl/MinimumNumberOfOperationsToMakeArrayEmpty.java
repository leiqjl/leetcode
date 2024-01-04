package com.leiqjl;

import java.util.HashMap;
import java.util.Map;

/**
 * 2870. Minimum Number of Operations to Make Array Empty - Medium
 */
public class MinimumNumberOfOperationsToMakeArrayEmpty {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        int result = 0;
        for (int count : countMap.values()) {
            if (count == 1) {
                return -1;
            }
            result = result + (count + 2) / 3;
        }
        return result;
    }
}
