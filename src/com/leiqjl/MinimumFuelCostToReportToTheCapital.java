package com.leiqjl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 2477. Minimum Fuel Cost to Report to the Capital - Medium
 */
public class MinimumFuelCostToReportToTheCapital {
    public long minimumFuelCost(int[][] roads, int seats) {
        Map<Integer, LinkedList<Integer>> graph = new HashMap<>();
        for (int[] road : roads) {
            graph.computeIfAbsent(road[0], v -> new LinkedList<>()).add(road[1]);
            graph.computeIfAbsent(road[1], v -> new LinkedList<>()).add(road[0]);
        }
        long[] result = dfs(graph, 0, -1, seats);
        return result[1];
    }

    private long[] dfs(Map<Integer, LinkedList<Integer>> graph, int s, int p, int seats) {
        long[] result = new long[]{1, 0};
        if (!graph.containsKey(s)) {
            return result;
        }
        for (int next : graph.get(s)) {
            if (next == p) {
                continue;
            }
            long[] ret = dfs(graph, next, s, seats);
            result[0] += ret[0];
            result[1] = result[1] + ret[1] + (ret[0] + seats - 1) / seats;
        }
        return result;
    }

    public static void main(String[] args) {
        MinimumFuelCostToReportToTheCapital m = new MinimumFuelCostToReportToTheCapital();
        //Input: roads = [[0,1],[0,2],[0,3]], seats = 5
        //Output: 3
        int[][] roads =  {{0,1},{0,2},{0,3}};
        assert m.minimumFuelCost(roads, 5) == 3;
        //Input: roads = [[3,1],[3,2],[1,0],[0,4],[0,5],[4,6]], seats = 2
        //Output: 7
        int[][] roads1 =  {{3,1},{3,2},{1,0},{0,4},{0,5},{4,6}};
        assert m.minimumFuelCost(roads1, 2) == 7;
        //Input: roads = [], seats = 1
        //Output: 0
        int[][] roads2 = {};
        assert m.minimumFuelCost(roads2, 1) == 0;
    }
}
