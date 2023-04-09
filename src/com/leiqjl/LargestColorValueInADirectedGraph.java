package com.leiqjl;

import java.util.*;

/**
 * 1857. Largest Color Value in a Directed Graph - Hard
 */
public class LargestColorValueInADirectedGraph {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        int[] indegree = new int[n];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], v -> new ArrayList<>()).add(edge[1]);
            indegree[edge[1]]++;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                deque.offer(i);
            }
        }
        int[][] count = new int[n][26];
        int num = 0, result = -1;
        while (!deque.isEmpty()) {
            int poll = deque.poll();
            count[poll][colors.charAt(poll) - 'a']++;
            result = Math.max(result, count[poll][colors.charAt(poll) - 'a']);
            num++;
            if (!graph.containsKey(poll)) {
                continue;
            }
            for (int neighbor : graph.get(poll)) {
                for (int i = 0; i < 26; i++) {
                    count[neighbor][i] = Math.max(count[neighbor][i], count[poll][i]);
                }
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    deque.offer(neighbor);
                }
            }
        }
        return num == n ? result : -1;
    }
}
