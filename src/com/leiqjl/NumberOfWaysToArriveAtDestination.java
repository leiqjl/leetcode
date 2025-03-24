package com.leiqjl;

import java.util.*;

/**
 * 1976. Number of Ways to Arrive at Destination - Medium
 */
public class NumberOfWaysToArriveAtDestination {
    public int countPaths(int n, int[][] roads) {
        int MOD = 1_000_000_007;
        Map<Integer, LinkedList<int[]>> graph = new HashMap<>();
        for (int[] road : roads) {
            graph.computeIfAbsent(road[0], v -> new LinkedList<>()).add(new int[]{road[1], road[2]});
            graph.computeIfAbsent(road[1], v -> new LinkedList<>()).add(new int[]{road[0], road[2]});
        }
        long[] times = new long[n];
        Arrays.fill(times, Long.MAX_VALUE);
        times[0] = 0;
        int[] paths = new int[n];
        paths[0] = 1;
        PriorityQueue<long[]> minHeap = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        minHeap.offer(new long[]{0, 0});
        while (!minHeap.isEmpty()) {
            long[] poll = minHeap.poll();
            int node = (int) poll[0];
            long time = poll[1];
            if (time > times[node]) {
                continue;
            }
            if (!graph.containsKey(node)) {
                continue;
            }
            for (int[] neighbor : graph.get(node)) {
                if (time + neighbor[1] < times[neighbor[0]]) {
                    times[neighbor[0]] = time + neighbor[1];
                    paths[neighbor[0]] = paths[node];
                    minHeap.offer(new long[]{neighbor[0], times[neighbor[0]]});
                } else if (time + neighbor[1] == times[neighbor[0]]) {
                    paths[neighbor[0]] = (paths[neighbor[0]] + paths[node]) % MOD;
                }
            }
        }
        return paths[n - 1];
    }
}
