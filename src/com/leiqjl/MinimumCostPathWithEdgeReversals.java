package com.leiqjl;

import java.util.*;

/**
 * 3650. Minimum Cost Path with Edge Reversals - Medium
 */
public class MinimumCostPathWithEdgeReversals {

    public int minCost(int n, int[][] edges) {
        List<int[]>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            int x = e[0];
            int y = e[1];
            int w = e[2];
            g[x].add(new int[]{y, w});
            g[y].add(new int[]{x, 2 * w});
        }

        // Dijkstra
        int[] d = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                Comparator.comparingInt(a -> a[0])
        );
        pq.offer(new int[]{0, 0}); // [Distance, Node]

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int dist = current[0];
            int x = current[1];

            if (x == n - 1) {
                return dist;
            }

            if (visited[x]) {
                continue;
            }
            visited[x] = true;

            for (int[] neighbor : g[x]) {
                int y = neighbor[0];
                int w = neighbor[1];

                if (dist + w < d[y]) {
                    d[y] = dist + w;
                    pq.offer(new int[]{d[y], y});
                }
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        MinimumCostPathWithEdgeReversals m = new MinimumCostPathWithEdgeReversals();

        // Test case 1: Input: n = 4, edges = [[0,1,3],[3,1,1],[2,3,4],[0,2,2]]
        int n1 = 4;
        int[][] edges1 = {{0, 1, 3}, {3, 1, 1}, {2, 3, 4}, {0, 2, 2}};
        int expected1 = 5;
        int result1 = m.minCost(n1, edges1);
        assert result1 == expected1 : "Test case 1 failed: expected " + expected1 + ", but got " + result1;
        System.out.println("Test case 1 passed: " + result1);

        // Test case 2: Input: n = 4, edges = [[0,2,1],[2,1,1],[1,3,1],[2,3,3]]
        int n2 = 4;
        int[][] edges2 = {{0, 2, 1}, {2, 1, 1}, {1, 3, 1}, {2, 3, 3}};
        int expected2 = 3;
        int result2 = m.minCost(n2, edges2);
        assert result2 == expected2 : "Test case 2 failed: expected " + expected2 + ", but got " + result2;
        System.out.println("Test case 2 passed: " + result2);
    }
}