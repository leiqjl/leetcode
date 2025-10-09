package com.leiqjl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * 1488. Avoid Flood in The City - Medium
 */
public class AvoidFloodInTheCity {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] result = new int[n];
        Arrays.fill(result, 1);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if (rains[i] > 0) {
                result[i] = -1;
                if (hashMap.containsKey(rains[i])) {
                    Integer index = treeSet.ceiling(hashMap.get(rains[i]));
                    if (index == null) {
                        return new int[0];
                    }
                    result[index] = rains[i];
                    treeSet.remove(index);
                }
                hashMap.put(rains[i], i);
            } else {
                treeSet.add(i);
            }
        }
        return result;
    }
}
