package com.leiqjl;

import java.util.ArrayList;
import java.util.List;

/**
 * 1557. Minimum Number of Vertices to Reach All Nodes - Medium
 */
public class MinimumNumberOfVerticesToReachAllNodes {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> result = new ArrayList<>();
        int[] indegree = new int[n];
        for (List<Integer> edge : edges) {
            indegree[edge.get(1)]++;
        }
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                result.add(i);
            }
        }
        return result;
    }

}
