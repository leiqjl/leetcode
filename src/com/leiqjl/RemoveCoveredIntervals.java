package com.leiqjl;

import java.util.Arrays;

/**
 * 1288. Remove Covered Intervals - Medium
 */
public class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int res = 0, end = 0;
        for (int[] interval : intervals) {
            if (interval[1] > end) {
                end = interval[1];
                res++;
            }
        }
        return res;
    }
}
