package com.leiqjl;

import java.util.Arrays;

/**
 * 3532. Path Existence Queries in a Graph I - Medium
 */
public class PathExistenceQueriesInAGraphI {
    //Constraints:
    //
    //1 <= n == nums.length <= 10^5
    //0 <= nums[i] <= 10^5
    //nums is sorted in non-decreasing order.
    //0 <= maxDiff <= 10^5
    //1 <= queries.length <= 10^5
    //queries[i] == [ui, vi]
    //0 <= ui, vi < n
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] group = new int[n];
        int g = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] > maxDiff) {
                g++;
            }
            group[i] = g;
        }
        boolean[] existences = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (group[queries[i][0]] == group[queries[i][1]]) {
                existences[i] = true;
            }
        }
        return existences;
    }

    public static void main(String[] args) {
        PathExistenceQueriesInAGraphI p = new PathExistenceQueriesInAGraphI();
        //Input: n = 2, nums = [1,3], maxDiff = 1, queries = [[0,0],[0,1]]
        //Output: [true,false]
        assert Arrays.equals(p.pathExistenceQueries(2, new int[]{1, 3}, 1, new int[][]{{0, 0}, {0, 1}}), new boolean[]{true, false});
        //Input: n = 4, nums = [2,5,6,8], maxDiff = 2, queries = [[0,1],[0,2],[1,3],[2,3]]
        //Output: [false,false,true,true]
        assert Arrays.equals(p.pathExistenceQueries(4, new int[]{2, 5, 6, 8}, 2, new int[][]{{0, 1}, {0, 2}, {1, 3}, {2, 3}}), new boolean[]{false, false, true, true});
    }
}
