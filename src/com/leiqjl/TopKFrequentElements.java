package com.leiqjl;

import java.util.*;

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
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new List[nums.length + 1];
        map.forEach((key, value) -> {
            if (buckets[value] == null) {
                buckets[value] = new ArrayList<>();
            }
            buckets[value].add(key);
        });
        int pos = 0;
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] != null) {
                for (int j : buckets[i]) {
                    result[pos++] = j;
                    if (pos == k) {
                        return result;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TopKFrequentElements t = new TopKFrequentElements();
        assert "[1, 2]".equals(Arrays.toString(t.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        assert "[1]".equals(Arrays.toString(t.topKFrequent(new int[]{1}, 1)));
    }
}
