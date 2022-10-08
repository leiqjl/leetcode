package com.leiqjl;

import java.util.PriorityQueue;

/**
 * 871. Minimum Number of Refueling Stops - Hard
 */
public class MinimumNumberOfRefuelingStops {

    // time O(NlogN) space O(N)
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int idx = 0, count = 0;
        while (startFuel < target) {
            while (idx < stations.length && stations[idx][0] <= startFuel) {
                maxHeap.add(stations[idx++][1]);
            }
            if (maxHeap.isEmpty()) {
                return -1;
            }
            startFuel += maxHeap.poll();
            count++;
        }
        return count;
    }

    // time O(N^2) space O(N)
    public int minRefuelStops1(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        long[] dp = new long[n + 1];
        dp[0] = startFuel;
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (dp[j] >= stations[i][0]) {
                    dp[j + 1] = Math.max(dp[j + 1], dp[j] + stations[i][1]);
                }
            }
        }
        for (int i = 0; i <= n; i++) {
            if (dp[i] >= target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MinimumNumberOfRefuelingStops m = new MinimumNumberOfRefuelingStops();
        //Input: target = 1, startFuel = 1, stations = []
        //Output: 0
        //Explanation: We can reach the target without refueling.
        int[][] s = {};
        assert m.minRefuelStops(1, 1, s) == 0;
        //Input: target = 100, startFuel = 1, stations = [[10,100]]
        //Output: -1
        //Explanation: We can not reach the target (or even the first gas station).
        int[][] s1 = {{10, 100}};
        assert m.minRefuelStops(100, 1, s1) == -1;
        //Input: target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
        //Output: 2
        //Explanation: We start with 10 liters of fuel.
        //We drive to position 10, expending 10 liters of fuel.  We refuel from 0 liters to 60 liters of gas.
        //Then, we drive from position 10 to position 60 (expending 50 liters of fuel),
        //and refuel from 10 liters to 50 liters of gas.  We then drive to and reach the target.
        //We made 2 refueling stops along the way, so we return 2.
        int[][] s2 = {{10, 60}, {20, 30}, {30, 30}, {60, 40}};
        assert m.minRefuelStops(100, 10, s2) == 2;

        int[][] s3 = {{25, 30}};
        assert m.minRefuelStops(100, 50, s3) == -1;
    }
}
