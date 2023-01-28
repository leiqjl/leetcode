package com.leiqjl;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * 352. Data Stream as Disjoint Intervals - Hard
 */
public class DataStreamAsDisjointIntervals {
    class SummaryRanges {
        TreeMap<Integer, Integer> treeMap;

        public SummaryRanges() {
            treeMap = new TreeMap<>();
        }

        public void addNum(int value) {
            if (treeMap.containsKey(value)) {
                return;
            }
            Integer lowerKey = treeMap.lowerKey(value);
            Integer higherKey = treeMap.higherKey(value);
            if (lowerKey != null && higherKey != null
                    && value == treeMap.get(lowerKey) + 1
                    && value + 1 == higherKey) {
                treeMap.put(lowerKey, treeMap.get(higherKey));
                treeMap.remove(higherKey);
            } else if (lowerKey != null && value <= treeMap.get(lowerKey) + 1) {
                treeMap.put(lowerKey, Math.max(treeMap.get(lowerKey), value));
            } else if (higherKey != null && value == higherKey - 1) {
                treeMap.put(value, treeMap.get(higherKey));
                treeMap.remove(higherKey);
            } else {
                treeMap.put(value, value);
            }
        }

        public int[][] getIntervals() {
            List<int[]> result = new ArrayList<>();
            for (int key : treeMap.keySet()) {
                result.add(new int[]{key, treeMap.get(key)});
            }
            return result.toArray(new int[treeMap.size()][2]);
        }
    }
}
