package com.leiqjl;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 2099. Find Subsequence of Length K With the Largest Sum - Easy
 */
public class FindSubsequenceOfLengthKWithTheLargestSum {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < nums.length; i++) {
            if (minHeap.size() < k) {
                minHeap.offer(new int[]{nums[i], i});
            } else if (nums[i] > minHeap.peek()[0]) {
                minHeap.poll();
                minHeap.offer(new int[]{nums[i], i});
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = minHeap.poll()[1];
        }
        Arrays.sort(ans);
        for (int i = 0; i < k; i++) {
            ans[i] = nums[ans[i]];
        }
        return ans;
    }
}
