package com.leiqjl;

import java.util.PriorityQueue;

/**
 * 2336. Smallest Number in Infinite Set - Medium
 */
public class SmallestNumberInInfiniteSet {
    //Constraints:
    //
    //1 <= num <= 1000
    //At most 1000 calls will be made in total to popSmallest and addBack.
    class SmallestInfiniteSet {
        int smallest = 1;
        boolean[] isPresent = new boolean[1001];
        PriorityQueue<Integer> minHeap;
        public SmallestInfiniteSet() {
            minHeap = new PriorityQueue<>();
        }

        public int popSmallest() {
            if (!minHeap.isEmpty()) {
                isPresent[minHeap.peek()] = false;
                return minHeap.poll();
            } else {
                return smallest++;
            }
        }

        public void addBack(int num) {
            if (num >= smallest || isPresent[num]) {
                return;
            }
            isPresent[num] = true;
            minHeap.add(num);
        }
    }
}
