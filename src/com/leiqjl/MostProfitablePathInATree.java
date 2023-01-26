package com.leiqjl;

import java.util.LinkedList;

/**
 * 2467. Most Profitable Path in a Tree - Medium
 */
public class MostProfitablePathInATree {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        boolean[] seen = new boolean[n];
        LinkedList<Integer>[] graph = new LinkedList[amount.length];
        for (int i = 0; i < amount.length; i++) graph[i] = new LinkedList<>();
        for (int[] edge: edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int[] distB = new int[n];

        return dfs(0, 0, bob, graph, amount, seen, distB);
    }

    private int dfs(int s, int depth, int bob, LinkedList<Integer>[] graph, int[] amount, boolean[] seen, int[] distB) {
        int result = Integer.MIN_VALUE;
        seen[s] = true;
        distB[s] = s == bob ? 0 : amount.length;

        for (int neighbor : graph[s]) {
            if (seen[neighbor]) {
                continue;
            }
            result = Math.max(result, dfs(neighbor, depth + 1, bob, graph, amount, seen, distB));
            distB[s] = Math.min(distB[s], distB[neighbor] + 1);
        }
        if (result == Integer.MIN_VALUE) {
            result = 0;
        }
        if (depth < distB[s]) {
            result += amount[s];
        } else if (depth == distB[s]) {
            result += amount[s] / 2;
        }
        return result;
    }
}
