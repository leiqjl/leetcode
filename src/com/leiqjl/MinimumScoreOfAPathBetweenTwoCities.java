package com.leiqjl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 2492. Minimum Score of a Path Between Two Cities - Medium
 */
public class MinimumScoreOfAPathBetweenTwoCities {
    int min;
    public int minScore(int n, int[][] roads) {
        Map<Integer, LinkedList<int[]>> graph = new HashMap<>();
        for (int[] road : roads) {
            graph.computeIfAbsent(road[0], v -> new LinkedList<>()).add(new int[]{road[1], road[2]});
            graph.computeIfAbsent(road[1], v -> new LinkedList<>()).add(new int[]{road[0], road[2]});
        }
        boolean[] visited = new boolean[n + 1];
        min = Integer.MAX_VALUE;
        dfs(1, visited, graph);
        return min;
    }

    private void dfs(int s, boolean[] visited, Map<Integer, LinkedList<int[]>> graph) {
        visited[s] = true;
        if (!graph.containsKey(s)) {
            return;
        }
        for (int[] neighbor : graph.get(s)) {
            min = Math.min(min, neighbor[1]);
            if (visited[neighbor[0]]) {
                continue;
            }
            dfs(neighbor[0], visited, graph);
        }
    }

    public static void main(String[] args) {
        MinimumScoreOfAPathBetweenTwoCities m = new MinimumScoreOfAPathBetweenTwoCities();
        //Input: n = 4, roads = [[1,2,9],[2,3,6],[2,4,5],[1,4,7]]
        //Output: 5
        assert m.minScore(4, new int[][]{{1, 2, 9}, {2, 3, 6}, {2, 4, 5}, {1, 4, 7}}) == 5;
        //Input: n = 4, roads = [[1,2,2],[1,3,4],[3,4,7]]
        //Output: 2
        assert m.minScore(4, new int[][]{{1, 2, 2}, {1, 3, 4}, {3, 4, 7}}) == 2;
    }
}
