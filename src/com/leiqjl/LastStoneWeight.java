package com.leiqjl;

import java.util.PriorityQueue;

/**
 * 1046. Last Stone Weight - Easy
 */
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(stones.length, (a, b) -> Integer.compare(b, a));
        for (int i : stones) {
            pq.offer(i);
        }
        while (pq.size() >= 2) {
            int first = pq.poll();
            int second = pq.poll();
            if (first > second) {
                pq.offer(first - second);
            }
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }
}
