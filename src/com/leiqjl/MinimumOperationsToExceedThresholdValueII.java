package com.leiqjl;

import java.util.PriorityQueue;

/**
 * 3066. Minimum Operations to Exceed Threshold Value II - Medium
 * You are given a 0-indexed integer array nums, and an integer k.
 * <p>
 * You are allowed to perform some operations on nums, where in a single operation, you can:
 * <p>
 * ·Select the two smallest integers x and y from nums.
 * ·Remove x and y from nums.
 * ·Insert (min(x, y) * 2 + max(x, y)) at any position in the array.
 * <p>
 * Note that you can only apply the described operation if nums contains at least two elements.
 * <p>
 * Return the minimum number of operations needed so that all elements of the array are greater than or equal to k.
 */
public class MinimumOperationsToExceedThresholdValueII {
    //Constraints:
    //
    //2 <= nums.length <= 2 * 10^5
    //1 <= nums[i] <= 10^9
    //1 <= k <= 10^9
    //The input is generated such that an answer always exists. That is, there exists some sequence of operations after which all elements of the array are greater than or equal to k.
    public int minOperations(int[] nums, int k) {
        int count = 0;
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add((long) num);
        }
        while (minHeap.size() >= 2 && minHeap.peek() < k) {
            long x = minHeap.poll();
            long y = minHeap.poll();
            minHeap.add(x * 2 + y);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        MinimumOperationsToExceedThresholdValueII m = new MinimumOperationsToExceedThresholdValueII();
        assert m.minOperations(new int[]{2, 11, 10, 1, 3}, 10) == 2;
        assert m.minOperations(new int[]{1, 1, 2, 4, 9}, 20) == 4;
        assert m.minOperations(new int[]{1000000000, 999999999, 1000000000, 999999999, 1000000000, 999999999}, 1000000000) == 2;
    }
}
