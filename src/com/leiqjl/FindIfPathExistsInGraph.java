package com.leiqjl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 1971. Find if Path Exists in Graph - Easy
 */
public class FindIfPathExistsInGraph {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, LinkedList<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], v -> new LinkedList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], v -> new LinkedList<>()).add(edge[0]);
        }
        boolean[] seen = new boolean[n];

        return dfs(graph, source, destination, seen);
    }
    private boolean dfs(Map<Integer, LinkedList<Integer>> graph, int s, int target, boolean[] seen) {
        if (s == target) {
            return true;
        }
        if (seen[s]) {
            return false;
        }
        seen[s] = true;
        for (int next : graph.get(s)) {
            if (dfs(graph, next, target, seen)) {
                return true;
            }
        }
        return false;
    }
}
