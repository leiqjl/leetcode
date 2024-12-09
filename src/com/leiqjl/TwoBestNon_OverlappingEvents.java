package com.leiqjl;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 2054. Two Best Non-Overlapping Events - Medium
 */
public class TwoBestNon_OverlappingEvents {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int max = 0, sum = 0;
        for (int[] event : events) {
            while (!pq.isEmpty() && pq.peek()[0] < event[0]) {
                max = Math.max(pq.peek()[1], max);
                pq.poll();
            }
            sum = Math.max(sum, max + event[2]);
            pq.add(new int[]{event[1], event[2]});
        }
        return sum;
    }
}
