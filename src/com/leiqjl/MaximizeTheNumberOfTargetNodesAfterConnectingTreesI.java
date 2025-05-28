package com.leiqjl;

import java.util.ArrayList;
import java.util.List;

/**
 * 3372. Maximize the Number of Target Nodes After Connecting Trees I - Medium
 */
public class MaximizeTheNumberOfTargetNodesAfterConnectingTreesI {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;
        int[] count1 = countNodes(edges1, k);
        int[] count2 = countNodes(edges2, k - 1);
        int maxCount = 0;
        for (int c : count2) {
            maxCount = Math.max(maxCount, count2[c]);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = count1[i] + maxCount;
        }
        return ans;
    }

    private int[] countNodes(int[][] edges, int k) {
        int n = edges.length + 1;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            count[i] = dfs(i, -1, k, graph);
        }
        return count;
    }

    private int dfs(int cur, int parent, int k, List<List<Integer>> graph) {
        if (k < 0) {
            return 0;
        }
        int count = 1;
        for (int next : graph.get(cur)) {
            if (next == parent) {
                continue;
            }
            count += dfs(next, cur, k - 1, graph);
        }
        return count;
    }
}
