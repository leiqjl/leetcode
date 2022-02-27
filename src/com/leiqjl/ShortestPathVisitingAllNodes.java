package com.leiqjl;

import java.util.ArrayList;
import java.util.List;

/**
 * 847. Shortest Path Visiting All Nodes - Hard
 * <p>
 * You have an undirected, connected graph of n nodes labeled from 0 to n - 1.
 * You are given an array graph where graph[i] is a list of all the nodes connected with node i by an edge.
 * <p>
 * Return the length of the shortest path that visits every node.
 * You may start and stop at any node, you may revisit nodes multiple times, and you may reuse edges.
 */
public class ShortestPathVisitingAllNodes {

    /**
     *   0
     * / ｜ \
     * 1  2   3
     * Input: graph = [[1,2,3],[0],[0],[0]]
     * Output: 4
     * Explanation: One possible path is [1,0,2,0,3]
     *
     * BFS
     */
    public int shortestPathLength(int[][] graph) {
        if (graph.length == 1) {
            return 0;
        }
        int n = graph.length;
        int endMask = (1 << n) - 1;
        boolean[][] visit = new boolean[n][endMask];
        List<int[]> q = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            q.add(new int[]{i, 1 << i});
            visit[i][1 << i] = true;
        }
        int step = 0;
        while (!q.isEmpty()) {
            List<int[]> newq = new ArrayList<>();
            for (int[] p : q) {
                int i = p[0];
                int mask = p[1];
                for (int neighbor : graph[i]) {
                    int newMask = mask | (1 << neighbor);
                    if (newMask == endMask) {
                        return step + 1;
                    }
                    if (!visit[neighbor][newMask]) {
                        visit[neighbor][newMask] = true;
                        newq.add(new int[]{neighbor, newMask});
                    }
                }
            }
            q = newq;
            step++;
        }
        return 0;
    }

}
