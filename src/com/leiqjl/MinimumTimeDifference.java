package com.leiqjl;

import java.util.List;

/**
 * 539. Minimum Time Difference - Medium
 * Given a list of 24-hour clock time points in "HH:MM" format,
 * return the minimum minutes difference between any two time-points in the list.
 */
public class MinimumTimeDifference {
    //Constraints:
    //
    //2 <= timePoints.length <= 2 * 10^4
    //timePoints[i] is in the format "HH:MM".
    public int findMinDifference(List<String> timePoints) {
        boolean[] time = new boolean[24 * 60];
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (String timePoint : timePoints) {
            String[] split = timePoint.split(":");
            int minutes = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
            if (time[minutes]) {
                return 0;
            }
            time[minutes] = true;
            min = Math.min(min, minutes);
            max = Math.max(max, minutes);
        }
        int minDiff = 1440 - max + min;
        int prev = min;
        for (int i = min + 1; i <= max; i++) {
            if (time[i]) {
                minDiff = Math.min(minDiff, i - prev);
                prev = i;
            }
        }
        return minDiff;
    }

    public static void main(String[] args) {
        MinimumTimeDifference m = new MinimumTimeDifference();
        assert m.findMinDifference(List.of("23:59", "00:00")) == 1;
        assert m.findMinDifference(List.of("00:00", "23:59", "00:00")) == 0;
    }
}
