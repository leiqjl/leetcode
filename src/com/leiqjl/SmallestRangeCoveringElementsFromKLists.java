package com.leiqjl;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 632. Smallest Range Covering Elements from K Lists - Hard
 * You have k lists of sorted integers in non-decreasing order. Find the smallest range that includes at least one number from each of the k lists.
 * <p>
 * We define the range [a, b] is smaller than range [c, d] if b - a < d - c or a < c if b - a == d - c.
 */
public class SmallestRangeCoveringElementsFromKLists {

    //Constraints:
    //
    //nums.length == k
    //1 <= k <= 3500
    //1 <= nums[i].length <= 50
    //-10^5 <= nums[i][j] <= 10^5
    //nums[i] is sorted in non-decreasing order.
    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        int max = Integer.MIN_VALUE;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < k; i++) {
            int[] cur = {nums.get(i).get(0), i, 0};
            if (cur[0] > max) {
                max = cur[0];
            }
            minHeap.offer(cur);
        }
        int minLen = Integer.MAX_VALUE;
        int[] res = {Integer.MAX_VALUE, 0};
        while (minHeap.size() == k) {
            int[] cur = minHeap.poll();
            int i = cur[1];
            int j = cur[2];
            if (max - cur[0] < minLen) {
                minLen = max - cur[0];
                res[0] = cur[0];
                res[1] = max;
            }
            j++;
            if (j < nums.get(cur[1]).size()) {
                int[] next = {nums.get(i).get(j), i, j};
                if (next[0] > max) {
                    max = next[0];
                }
                minHeap.offer(next);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SmallestRangeCoveringElementsFromKLists s = new SmallestRangeCoveringElementsFromKLists();
        //[4,10,15,24,26] [0,9,12,20] [5,18,22,30] 0, 5
        //[4,10,15,24,26] [9,12,20] [5,18,22,30] 4, 9
        //[10,15,24,26] [9,12,20] [5,18,22,30] 5, 10
        //[10,15,24,26] [9,12,20] [18,22,30] 9, 18
        //[10,15,24,26] [12,20] [18,22,30] 10, 18
        //[15,24,26] [12,20] [18,22,30] 12, 18
        //[24,26] [20] [18,22,30] 18, 24
        //[24,26] [20] [22,30] 20, 24
        //[24,26] [] [22,30]  stop
        //Input: nums = [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
        //Output: [20,24]
        //Explanation:
        //List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
        //List 2: [0, 9, 12, 20], 20 is in range [20,24].
        //List 3: [5, 18, 22, 30], 22 is in range [20,24].
        assert Arrays.equals(s.smallestRange(List.of(List.of(4, 10, 15, 24, 26), List.of(0, 9, 12, 20), List.of(5, 18, 22, 30))), new int[]{20, 24});
        assert Arrays.equals(s.smallestRange(List.of(List.of(1, 2, 3), List.of(1, 2, 3), List.of(1, 2, 3))), new int[]{1, 1});
    }
}
