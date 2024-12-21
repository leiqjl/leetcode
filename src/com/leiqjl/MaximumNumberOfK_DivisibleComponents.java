package com.leiqjl;

import java.util.ArrayList;
import java.util.List;

/**
 * 2872. Maximum Number of K-Divisible Components - Hard
 */
public class MaximumNumberOfK_DivisibleComponents {
    int count = 0;
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        count = 0;
        dfs(0, -1, graph, values, k);
        return count;
    }

    private int dfs(int s, int p, List<Integer>[] graph, int[] values, int k) {
        int sum = 0;
        for (int next : graph[s]) {
            if (next != p) {
                sum += dfs(next, s, graph, values, k);
                sum %= k;
            }
        }
        sum += values[s];
        sum %= k;
        if (sum == 0) {
            count++;
        }
        return sum;
    }
}
