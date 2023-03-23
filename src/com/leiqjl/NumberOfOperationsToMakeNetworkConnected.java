package com.leiqjl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 1319. Number of Operations to Make Network Connected - Medium
 */
public class NumberOfOperationsToMakeNetworkConnected {

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for (int[] connection : connections) {
            graph.computeIfAbsent(connection[0], v -> new ArrayList<>()).add(connection[1]);
            graph.computeIfAbsent(connection[1], v -> new ArrayList<>()).add(connection[0]);
        }
        boolean[] visited = new boolean[n];
        int groupCount = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            groupCount++;
            dfs(i, graph, visited);
        }
        return groupCount - 1;
    }

    private void dfs(int s, Map<Integer, ArrayList<Integer>> graph, boolean[] visited) {
        visited[s] = true;
        if (!graph.containsKey(s)) {
            return;
        }
        for (int neighbor : graph.get(s)) {
            if (visited[neighbor]) {
                continue;
            }
            dfs(neighbor, graph, visited);
        }
    }

    public static void main(String[] args) {
        NumberOfOperationsToMakeNetworkConnected n = new NumberOfOperationsToMakeNetworkConnected();
        //Input: n = 4, connections = [[0,1],[0,2],[1,2]]
        //Output: 1
        //Explanation: Remove cable between computer 1 and 2 and place between computers 1 and 3.
        assert n.makeConnected(4, new int[][]{{0, 1}, {0, 2}, {1, 2}}) == 1;
        //Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
        //Output: 2
        assert n.makeConnected(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}}) == 2;
        //Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
        //Output: -1
        //Explanation: There are not enough cables.
        assert n.makeConnected(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}}) == -1;
    }
}
