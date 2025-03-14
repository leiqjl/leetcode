package com.leiqjl;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 3362. Zero Array Transformation III - Medium
 * You are given an integer array nums of length n and a 2D array queries where queries[i] = [li, ri].
 * <p>
 * Each queries[i] represents the following action on nums:
 * <p>
 * ·Decrement the value at each index in the range [li, ri] in nums by at most 1.
 * ·The amount by which the value is decremented can be chosen independently for each index.
 * A Zero Array is an array with all its elements equal to 0.
 * <p>
 * Return the maximum number of elements that can be removed from queries, such that nums can still be converted to a zero array using the remaining queries.
 * If it is not possible to convert nums to a zero array, return -1.
 */
public class ZeroArrayTransformationIII {
    //Constraints:
    //
    //1 <= nums.length <= 10^5
    //0 <= nums[i] <= 10^5
    //1 <= queries.length <= 10^5
    //queries[i].length == 2
    //0 <= li <= ri < nums.length
    public int maxRemoval(int[] nums, int[][] queries) {
        Arrays.sort(queries, (a, b) -> a[0] - b[0]);
        int[] diff = new int[nums.length + 1];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int val = 0;
        int qIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            val += diff[i];
            while (qIndex < queries.length && queries[qIndex][0] <= i) {
                maxHeap.offer(queries[qIndex][1]);
                qIndex++;
            }
            while (val < nums[i]) {
                if (maxHeap.isEmpty() || maxHeap.peek() < i) {
                    return -1;
                }
                diff[maxHeap.poll() + 1]--;
                val++;
            }
        }
        return maxHeap.size();
    }

    public static void main(String[] args) {
        ZeroArrayTransformationIII z = new ZeroArrayTransformationIII();
        //Input: nums = [2,0,2], queries = [[0,2],[0,2],[1,1]]
        //Output: 1
        assert z.maxRemoval(new int[]{2, 0, 2}, new int[][]{{0, 2}, {0, 2}, {1, 1}}) == 1;
        //Input: nums = [1,1,1,1], queries = [[1,3],[0,2],[1,3],[1,2]]
        //Output: 2
        assert z.maxRemoval(new int[]{1, 1, 1, 1}, new int[][]{{1, 3}, {0, 2}, {1, 3}, {1, 2}}) == 2;
        //Input: nums = [1,2,3,4], queries = [[0,3]]
        //Output: -1
        assert z.maxRemoval(new int[]{1, 2, 3, 4}, new int[][]{{0, 3}}) == -1;
    }
}
