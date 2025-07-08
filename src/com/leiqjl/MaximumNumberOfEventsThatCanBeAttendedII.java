package com.leiqjl;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1751. Maximum Number of Events That Can Be Attended II - Hard
 */
public class MaximumNumberOfEventsThatCanBeAttendedII {
    public int maxValue(int[][] events, int k) {
        int n = events.length;
        int[][] dp = new int[k + 1][n + 1];
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        for (int cur = n - 1; cur >= 0; cur--) {
            int next = binarySearch(events, events[cur][1]);
            for (int c = 1; c <= k; c++) {
                dp[c][cur] = Math.max(dp[c][cur + 1], events[cur][2] + dp[c - 1][next]);
            }
        }
        return dp[k][0];
    }

    private int binarySearch(int[][] events, int target) {
        int l = 0, r = events.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (events[mid][0] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
