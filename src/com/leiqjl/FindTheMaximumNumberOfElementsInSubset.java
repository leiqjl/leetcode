package com.leiqjl;

import java.util.HashMap;
import java.util.Map;

/**
 * 3020. Find the Maximum Number of Elements in Subset - Medium
 */
public class FindTheMaximumNumberOfElementsInSubset {
    public int maximumLength(int[] nums) {
        Map<Long, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put((long) num, freqMap.getOrDefault((long) num, 0) + 1);
        }
        int oneCounts = freqMap.getOrDefault(1L, 0);
        freqMap.remove(1L);
        int res = (oneCounts & 1) == 1 ? oneCounts : oneCounts - 1;
        for (long num : freqMap.keySet()) {
            int count = 0;
            long cur = num;
            while (freqMap.containsKey(cur) && freqMap.get(cur) > 1) {
                count += 2;
                cur *= cur;
            }
            count = count + (freqMap.containsKey(cur) ? 1 : -1);
            res = Math.max(count, res);
        }
        return res;
    }
}
