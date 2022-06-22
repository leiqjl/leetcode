package com.leiqjl;

import java.util.PriorityQueue;

/**
 * 215. Kth Largest Element in an Array - Medium
 */
public class KthLargestElementInAnArray {

    //1 <= k <= nums.length <= 10^4
    //-104 <= nums[i] <= 10^4

    //O(k+(n-k)lgk)
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (pq.peek() < num) {
                pq.offer(num);
                pq.poll();
            }
        }
        return pq.peek();
    }

}
