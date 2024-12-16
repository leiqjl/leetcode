package com.leiqjl;

import java.util.PriorityQueue;

/**
 * 3264. Final Array State After K Multiplication Operations I - Easy
 * You are given an integer array nums, an integer k, and an integer multiplier.
 * <p>
 * You need to perform k operations on nums. In each operation:
 * <p>
 * ·Find the minimum value x in nums. If there are multiple occurrences of the minimum value, select the one that appears first.
 * ·Replace the selected minimum value x with x * multiplier.
 * <p>
 * Return an integer array denoting the final state of nums after performing all k operations.
 */
public class FinalArrayStateAfterKMultiplicationOperationsI {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) :Integer.compare(a[0], b[0]));
        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        while (k-- > 0) {
            int[] poll = pq.poll();
            poll[0] *= multiplier;
            nums[poll[1]] = poll[0];
            pq.offer(poll);
        }
        return nums;
    }
}
