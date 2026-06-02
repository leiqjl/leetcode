package com.leiqjl;

/**
 * 3633. Earliest Finish Time for Land and Water Rides I - Easy
 */
public class EarliestFinishTimeForLandAndWaterRidesI {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int landTime = mintTime(landStartTime, landDuration, waterStartTime, waterDuration);
        int waterTime = mintTime(waterStartTime, waterDuration, landStartTime, landDuration);
        return Math.min(landTime, waterTime);
    }

    public int mintTime(int[] startTime1, int[] duration1, int[] startTime2, int[] duration2) {
        int minTime = Integer.MAX_VALUE;
        int time1 = Integer.MAX_VALUE;
        for (int i = 0; i < startTime1.length; i++) {
            time1 = Math.min(time1, startTime1[i] + duration1[i]);
        }
        for (int i = 0; i < startTime2.length; i++) {
            minTime = Math.min(minTime, Math.max(time1, startTime2[i]) + duration2[i]);
        }
        return minTime;
    }
}
