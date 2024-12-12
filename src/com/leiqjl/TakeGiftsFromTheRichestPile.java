package com.leiqjl;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 2558. Take Gifts From the Richest Pile - Easy
 */
public class TakeGiftsFromTheRichestPile {
    public long pickGifts(int[] gifts, int k) {
        long sum = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int gift : gifts) {
            maxHeap.offer(gift);
            sum += gift;
        }
        while (k > 0) {
            int poll = maxHeap.poll();
            if (poll == 1) {
                break;
            }
            int sqrt = (int) Math.sqrt(poll);
            maxHeap.offer(sqrt);
            sum = sum - (poll - sqrt);
            k--;
        }
        return sum;
    }
}
