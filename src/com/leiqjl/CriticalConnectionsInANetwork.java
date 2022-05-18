package com.leiqjl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 1192. Critical Connections in a Network - Hard
 */
public class CriticalConnectionsInANetwork {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (List<Integer> connection : connections) {
            int v = connection.get(0);
            int w = connection.get(1);
            graph[v].add(w);
            graph[w].add(v);
        }
        int[] level = new int[1];
        level[0] = 1;
        int[] visit = new int[n];

        dfs(0, -1, graph, level, visit, result);
        return result;
    }

    private void dfs(int s, int p, LinkedList<Integer>[] graph, int[] level, int[] visit, List<List<Integer>> result) {
        visit[s] = level[0]++;
        int curLevel = visit[s];
        for (int neighbor : graph[s]) {
            if (neighbor == p) {
                continue;
            }
            if (visit[neighbor] == 0) {
                dfs(neighbor, s, graph, level, visit, result);
            }
            visit[s] = Math.min(visit[s], visit[neighbor]);
            if (curLevel < visit[neighbor]) {
                result.add(Arrays.asList(s, neighbor));
            }
        }
    }
}
