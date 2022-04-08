package com.leiqjl;

import java.util.PriorityQueue;

/**
 * 703. Kth Largest Element in a Stream - Easy
 */
public class KthLargestElementInAStream {
    class KthLargest {
        int k;
        PriorityQueue<Integer> pq;
        //Initializes the object with the integer k and the stream of integers nums.
        public KthLargest(int k, int[] nums) {
            this.k = k;
            pq = new PriorityQueue<>(k);
            for (int num : nums) {
                add(num);
            }
        }

        //Appends the integer val to the stream and returns the element representing the kth largest element in the stream.
        public int add(int val) {
            if (pq.size() < k) {
                pq.offer(val);
            } else if (pq.peek() < val) {
                pq.poll();
                pq.offer(val);
            }
            return pq.peek();
        }
    }
}
