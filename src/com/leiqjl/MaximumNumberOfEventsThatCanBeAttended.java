package com.leiqjl;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1353. Maximum Number of Events That Can Be Attended - Medium
 */
public class MaximumNumberOfEventsThatCanBeAttended {
    public int maxEvents(int[][] events) {

        int count = 0;
        int maxDay = 0;
        for (int[] event : events) {
            maxDay = Math.max(maxDay, event[1]);
        }
        int day = 1, index = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        while (day <= maxDay) {
            while (index < events.length && events[index][0] <= day) {
                minHeap.offer(events[index][1]);
                index++;
            }
            while (!minHeap.isEmpty() && minHeap.peek() < day) {
                minHeap.poll();
            }
            if (!minHeap.isEmpty()) {
                minHeap.poll();
                count++;
            }
            day++;
        }
        return count;
    }
}
