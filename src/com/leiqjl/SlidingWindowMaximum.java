package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 239. Sliding Window Maximum - Hard
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * <p>
 * Return the max sliding window.
 */
public class SlidingWindowMaximum {
    //Monotonic Queue
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>(k);
        for (int i = 0; i < nums.length; i++) {
            if (i >= k && deque.getFirst() == nums[i - k]) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.getLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            if (i >= k - 1) {
                res[i - k + 1] = deque.getFirst();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum s = new SlidingWindowMaximum();
        assert Arrays.toString(s.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)).equals("[3, 3, 5, 5, 6, 7]");
        assert Arrays.toString(s.maxSlidingWindow(new int[]{1}, 1)).equals("[1]");
        assert Arrays.toString(s.maxSlidingWindow(new int[]{1, -1}, 1)).equals("[1, -1]");

    }
}
