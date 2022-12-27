package com.leiqjl;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * 56. Merge Intervals - Medium
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        LinkedList<int[]> result = new LinkedList<>();
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (result.getLast()[1] < intervals[i][0]) {
                result.add(intervals[i]);
            } else {
                result.getLast()[1] = Math.max(result.getLast()[1], intervals[i][1]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
