package com.leiqjl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 1443. Minimum Time to Collect All Apples in a Tree - Medium
 */
public class MinimumTimeToCollectAllApplesInATree {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, LinkedList<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], v -> new LinkedList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], v -> new LinkedList<>()).add(edge[0]);
        }
        return dfs(0, -1, graph, hasApple);
    }

    private int dfs(int s, int p, Map<Integer, LinkedList<Integer>> graph, List<Boolean> hasApple) {
        if (!graph.containsKey(s)) {
            return 0;
        }
        int totalTime = 0, time = 0;
        for (int child : graph.get(s)) {
            if (child == p) {
                continue;
            }
            time = dfs(child, s, graph, hasApple);
            if (time > 0 || hasApple.get(child)) {
                totalTime = totalTime + time + 2;
            }
        }
        return totalTime;
    }
}
