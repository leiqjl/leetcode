package com.leiqjl;

import java.util.HashMap;
import java.util.Map;

/**
 * 1865. Finding Pairs With a Certain Sum - Medium
 */
public class FindingPairsWithACertainSum {
    class FindSumPairs {
        int[] nums1;
        int[] nums2;
        Map<Integer, Integer> freqMap;

        public FindSumPairs(int[] nums1, int[] nums2) {
            this.nums1 = nums1;
            this.nums2 = nums2;
            freqMap = new HashMap<>();
            for (int num : nums2) {
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            }
        }

        public void add(int index, int val) {
            int origin = nums2[index];
            freqMap.put(origin, freqMap.get(origin) - 1);
            int newVal = origin + val;
            freqMap.put(newVal, freqMap.getOrDefault(newVal, 0) + 1);
            nums2[index] = newVal;
        }

        public int count(int tot) {
            int res = 0;
            for (int num : nums1) {
                res = res + freqMap.getOrDefault(tot - num, 0);
            }
            return res;
        }
    }
}
