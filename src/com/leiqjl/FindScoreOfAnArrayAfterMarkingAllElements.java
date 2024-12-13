package com.leiqjl;

import java.util.PriorityQueue;

/**
 * 2593. Find Score of an Array After Marking All Elements - Medium
 * You are given an array nums consisting of positive integers.
 * <p>
 * Starting with score = 0, apply the following algorithm:
 * <p>
 * ·Choose the smallest integer of the array that is not marked. If there is a tie, choose the one with the smallest index.
 * ·Add the value of the chosen integer to score.
 * ·Mark the chosen element and its two adjacent elements if they exist.
 * ·Repeat until all the array elements are marked.
 * <p>
 * Return the score you get after applying the above algorithm.
 */
public class FindScoreOfAnArrayAfterMarkingAllElements {
    public long findScore(int[] nums) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        boolean[] marked = new boolean[n];
        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        long result = 0;
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            if (marked[poll[1]]) {
                continue;
            }
            if (poll[1] - 1 >= 0) {
                marked[poll[1] - 1] = true;
            }
            if (poll[1] + 1 < n) {
                marked[poll[1] + 1] = true;
            }
            result += nums[poll[1]];
            marked[poll[1]] = true;
        }
        return result;
    }


    public static void main(String[] args) {
        FindScoreOfAnArrayAfterMarkingAllElements f = new FindScoreOfAnArrayAfterMarkingAllElements();
        assert f.findScore(new int[]{2, 1, 3, 4, 5, 2}) == 7;
        assert f.findScore(new int[]{2, 3, 5, 1, 3, 2}) == 5;

    }

}
