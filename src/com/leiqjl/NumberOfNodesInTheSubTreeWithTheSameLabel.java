package com.leiqjl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 1519. Number of Nodes in the Sub-Tree With the Same Label - Medium
 */
public class NumberOfNodesInTheSubTreeWithTheSameLabel {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        int[] answer = new int[n];
        Map<Integer, LinkedList<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], v -> new LinkedList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], v -> new LinkedList<>()).add(edge[0]);
        }
        int[] count = new int[26];
        dfs(0, -1, graph, answer, count, labels);
        return answer;
    }

    private void dfs(int s, int p, Map<Integer, LinkedList<Integer>> graph, int[] answer, int[] count, String labels) {
        int prev = count[labels.charAt(s) - 'a'];
        count[labels.charAt(s) - 'a']++;
        for (int child : graph.get(s)) {
            if (child == p) {
                continue;
            }
            dfs(child, s, graph, answer, count, labels);
        }
        answer[s] = count[labels.charAt(s) - 'a'] - prev;
    }
}
