package com.leiqjl;

import java.util.PriorityQueue;

/**
 * 295. Find Median from Data Stream - Hard
 */
public class FindMedianFromDataStream {
    class MedianFinder {
        PriorityQueue<Integer> maxHeap;
        PriorityQueue<Integer> minHeap;

        public MedianFinder() {
            maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
            minHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (maxHeap.size() > minHeap.size()) {
                maxHeap.add(num);
                minHeap.add(maxHeap.remove());
            } else {
                minHeap.add(num);
                maxHeap.add(minHeap.remove());
            }
        }

        public double findMedian() {
            if (maxHeap.size() > minHeap.size()) {
                return maxHeap.peek();
            } else {
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            }
        }
    }
}
