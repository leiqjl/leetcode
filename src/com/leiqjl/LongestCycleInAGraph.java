package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 2360. Longest Cycle in a Graph - Hard
 */
public class LongestCycleInAGraph {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        int[] indegree = new int[n];
        boolean[] visited = new boolean[n];
        for (int edge : edges) {
            if (edge != -1) {
                indegree[edge]++;
            }
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n;i++) {
            if (indegree[i] == 0) {
                deque.offer(i);
            }
        }
        while (!deque.isEmpty()) {
            int poll = deque.poll();
            visited[poll] = true;
            int neighbor = edges[poll];
            if (neighbor != -1) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    deque.offer(neighbor);
                }
            }
        }
        int result = -1;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            int count = 1;
            int neighbor = edges[i];
            while (neighbor != i) {
                visited[neighbor] = true;
                count++;
                neighbor = edges[neighbor];
            }
            result = Math.max(result, count);
        }
        return result;
    }
    int result = -1;
    public int longestCycle1(int[] edges) {
        int n = edges.length;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            Map<Integer, Integer> distMap = new HashMap<>();
            distMap.put(i, 0);
            dfs(i, edges, visited, distMap);
        }
        return result;
    }

    private void dfs(int s, int[] edges, boolean[] visited, Map<Integer, Integer> distMap) {
        visited[s] = true;
        int neighbor = edges[s];
        if (neighbor == -1) {
            return;
        }
        if (!visited[neighbor]) {
            distMap.put(neighbor, distMap.get(s) + 1);
            dfs(neighbor, edges, visited, distMap);
            return;
        }
        if (distMap.containsKey(neighbor)) {
            result = Math.max(result, distMap.get(s)-distMap.get(neighbor)+1);
        }
    }
}
