package com.leiqjl;

import java.util.*;

/**
 * 1857. Largest Color Value in a Directed Graph - Hard
 */
public class LargestColorValueInADirectedGraph {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        int[] indegree = new int[n];
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            indegree[e[1]]++;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                deque.offer(i);
            }
        }
        int ans = 0;
        int visitedCount = 0;
        int[][] countColors = new int[n][26];
        while (!deque.isEmpty()) {
            int cur = deque.poll();
            int color = colors.charAt(cur) - 'a';
            countColors[cur][color]++;
            ans = Math.max(ans, countColors[cur][color]);
            visitedCount++;

            for (int next : graph[cur]) {
                for (int c = 0; c < 26; c++) {
                    if (countColors[next][c] < countColors[cur][c]) {
                        countColors[next][c] = countColors[cur][c];
                    }
                }
                indegree[next]--;
                if (indegree[next] == 0) {
                    deque.offer(next);
                }
            }

        }
        return visitedCount == n ? ans : -1;
    }
}
