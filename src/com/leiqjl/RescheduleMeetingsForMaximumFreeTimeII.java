package com.leiqjl;

/**
 * 3440. Reschedule Meetings for Maximum Free Time II - Medium
 */
public class RescheduleMeetingsForMaximumFreeTimeII {
    //Constraints:
    //
    //1 <= eventTime <= 109
    //n == startTime.length == endTime.length
    //2 <= n <= 10^5
    //0 <= startTime[i] < endTime[i] <= eventTime
    //endTime[i] <= startTime[i + 1] where i lies in the range [0, n - 2].
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int res = 0;
        boolean[] existTimeSlots = new boolean[n];
        int time = 0;
        for (int i = 0; i < n; i++) {
            if (endTime[i] - startTime[i] <= time) {
                existTimeSlots[i] = true;
            }
            time = Math.max(time, startTime[i] - (i == 0 ? 0 : endTime[i - 1]));
        }
        time = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (endTime[i] - startTime[i] <= time) {
                existTimeSlots[i] = true;
            }
            time = Math.max(time, (i == n - 1 ? eventTime : startTime[i + 1] )- endTime[i]);
        }
        for (int i = 0; i < n; i++) {
            int l = i == 0 ? 0 : endTime[i - 1];
            int r = i == n - 1 ? eventTime : startTime[i + 1];
            if (existTimeSlots[i]) {
                res = Math.max(res, r - l);
            } else {
                res = Math.max(res, r - l - (endTime[i] - startTime[i]));
            }
        }
        return res;
    }

}
