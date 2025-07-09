package com.leiqjl;

/**
 * 3439. Reschedule Meetings for Maximum Free Time I - Medium
 */
public class RescheduleMeetingsForMaximumFreeTimeI {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int res = 0;
        int time = 0;
        for (int i = 0; i < n; i++) {
            time += (endTime[i] - startTime[i]);
            int l = i > k - 1 ? endTime[i - k] : 0;
            int r = i < n - 1 ? startTime[i + 1] : eventTime;
            res = Math.max(res, r - l - time);
            if (i >= k - 1) {
                time -= (endTime[i - (k - 1)] - startTime[i - (k - 1)]);
            }
        }
        return res;
    }
}
