package com.leiqjl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 347. Top K Frequent Elements - Medium
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 */
public class TopKFrequentElements {
    //1 <= nums.length <= 105
    //k is in the range [1, the number of unique elements in the array].
    //It is guaranteed that the answer is unique.
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer>[] bucket = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (bucket[entry.getValue()] == null) {
                bucket[entry.getValue()] = new LinkedList<>();
            }
            bucket[entry.getValue()].add(entry.getKey());
        }
        int pos = 0;
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                for (int j : bucket[i]) {
                    result[pos++] = j;
                }
            }
        }
        return result;
    }
}
