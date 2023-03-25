package com.leiqjl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 2316. Count Unreachable Pairs of Nodes in an Undirected Graph - Medium
 */
public class CountUnreachablePairsOfNodesInAnUndirectedGraph {
    public long countPairs(int n, int[][] edges) {
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], v -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], v -> new ArrayList<>()).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        long groupCount = 0;
        long remainCount = n;
        long result = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            groupCount = dfs(i, graph, visited);
            remainCount -= groupCount;
            result += groupCount * remainCount;
        }

        return result;
    }

    private int dfs(int s, Map<Integer, ArrayList<Integer>> graph, boolean[] visited) {
        visited[s] = true;
        if (!graph.containsKey(s)) {
            return 1;
        }
        int count = 1;
        for (int neighbor : graph.get(s)) {
            if (visited[neighbor]) {
                continue;
            }
            count += dfs(neighbor, graph, visited);
        }
        return count;
    }
}
