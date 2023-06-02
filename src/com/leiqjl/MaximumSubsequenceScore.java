package com.leiqjl;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 2542. Maximum Subsequence Score - Medium
 * You are given two 0-indexed integer arrays nums1 and nums2 of equal length n and a positive integer k.
 * You must choose a subsequence of indices from nums1 of length k.
 * <p>
 * For chosen indices i0, i1, ..., ik - 1, your score is defined as:
 * <p>
 * - The sum of the selected elements from nums1 multiplied with the minimum of the selected elements from nums2.
 * - It can defined simply as: (nums1[i_0] + nums1[i_1] +...+ nums1[i_k-1]) * min(nums2[i_0] , nums2[i_1], ... ,nums2[i_k-1]).
 * Return the maximum possible score.
 * <p>
 * A subsequence of indices of an array is a set that can be derived from the set {0, 1, ..., n-1} by deleting some or no elements.
 */
public class MaximumSubsequenceScore {
    //Constraints:
    //
    //n == nums1.length == nums2.length
    //1 <= n <= 10^5
    //0 <= nums1[i], nums2[j] <= 10^5
    //1 <= k <= n
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums1[i];
            pairs[i][1] = nums2[i];
        }
        Arrays.sort(pairs, (a, b) -> b[1] - a[1]);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        long sum = 0;
        for (int i = 0; i < k; i++) {
            minHeap.offer(pairs[i][0]);
            sum += pairs[i][0];
        }
        long result = sum * pairs[k - 1][1];
        for (int i = k; i < n; i++) {
            if (minHeap.peek() < pairs[i][0]) {
                sum += (pairs[i][0] - minHeap.poll());
                minHeap.offer(pairs[i][0]);
                result = Math.max(result, sum * pairs[i][1]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MaximumSubsequenceScore m = new MaximumSubsequenceScore();
        //The four possible subsequence scores are:
        //- We choose the indices 0, 1, and 2 with score = (1+3+3) * min(2,1,3) = 7.
        //- We choose the indices 0, 1, and 3 with score = (1+3+2) * min(2,1,4) = 6.
        //- We choose the indices 0, 2, and 3 with score = (1+3+2) * min(2,3,4) = 12.
        //- We choose the indices 1, 2, and 3 with score = (3+3+2) * min(1,3,4) = 8.
        //Therefore, we return the max score, which is 12.
        assert m.maxScore(new int[]{1, 3, 3, 2}, new int[]{2, 1, 3, 4}, 3) == 12;
        //Choosing index 2 is optimal: nums1[2] * nums2[2] = 3 * 10 = 30 is the maximum possible score.
        assert m.maxScore(new int[]{4, 2, 3, 1, 1}, new int[]{7, 5, 10, 9, 6}, 1) == 30;
    }
}
