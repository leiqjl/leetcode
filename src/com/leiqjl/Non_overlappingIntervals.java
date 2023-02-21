package com.leiqjl;

import java.util.Arrays;

/**
 * 435. Non-overlapping Intervals - Medium
 */
public class Non_overlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int count = 1, end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                count++;
                end = intervals[i][1];
            }
        }
        return intervals.length - count;
    }

    public static void main(String[] args) {
        Non_overlappingIntervals n = new Non_overlappingIntervals();
        assert n.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}) == 1;
        assert n.eraseOverlapIntervals(new int[][]{{1, 2}, {1, 2}, {1, 2}}) == 2;
        assert n.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}}) == 0;
    }
}
