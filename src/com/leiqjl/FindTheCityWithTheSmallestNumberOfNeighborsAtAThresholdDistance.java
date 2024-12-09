package com.leiqjl;

import java.util.*;

/**
 * 1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance - Medium
 * <p>
 * There are n cities numbered from 0 to n-1. Given the array edges where edges[i] = [from_i, to_i, weight_i] represents a bidirectional and weighted edge between cities from_i and to_i, and given the integer distanceThreshold.
 * <p>
 * Return the city with the smallest number of cities that are reachable through some path and whose distance is at most distanceThreshold, If there are multiple such cities, return the city with the greatest number.
 * <p>
 * Notice that the distance of a path connecting cities i and j is equal to the sum of the edges' weights along that path.
 */
public class FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        LinkedList<int[]>[] graph = new LinkedList[n];
        int[][] shortestPath = new int[n][n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
            graph[edge[1]].add(new int[]{edge[0], edge[2]});
        }
        for (int i = 0; i < n; i++) {
            calShortestPath(graph, shortestPath, i, n);
        }
        int minCount = Integer.MAX_VALUE, maxIdx = -1;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (shortestPath[i][j] <= distanceThreshold && i != j) {
                    count++;
                }
            }
            if (count <= minCount) {
                minCount = count;
                maxIdx = i;
            }
        }
        return maxIdx;
    }
    //Dijkstra algorithm
    private void calShortestPath(LinkedList<int[]>[] graph, int[][] shortestPath, int cur, int n) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{cur, 0});
        Arrays.fill(shortestPath[cur], Integer.MAX_VALUE);
        shortestPath[cur][cur] = 0;
        while (!pq.isEmpty()) {
            int[] curNode = pq.poll();
            int x = curNode[0];
            int curDist = curNode[1];
            if (curDist > shortestPath[cur][x]) {
                continue;
            }
            for (int[] next : graph[x]) {
                int nx = next[0];
                int nd = next[1];
                if (curDist + nd < shortestPath[cur][nx]) {
                    shortestPath[cur][nx] = curDist + nd;
                    pq.add(new int[]{nx, shortestPath[cur][nx]});
                }
            }
        }
    }

    public static void main(String[] args) {
        FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance f = new FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance();
        //Input: n = 4, edges = [[0,1,3],[1,2,1],[1,3,4],[2,3,1]], distanceThreshold = 4
        //Output: 3
        assert f.findTheCity(4, new int[][]{{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}}, 4) == 3;
        //Input: n = 5, edges = [[0,1,2],[0,4,8],[1,2,3],[1,4,2],[2,3,1],[3,4,1]], distanceThreshold = 2
        //Output: 0
        assert f.findTheCity(5, new int[][]{{0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}}, 2) == 0;
    }
}
