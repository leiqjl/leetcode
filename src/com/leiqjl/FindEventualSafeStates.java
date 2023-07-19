package com.leiqjl;

import java.util.*;

/**
 * 802. Find Eventual Safe States - Medium
 */
public class FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] outdegree = new int[n];
        boolean[] flag = new boolean[n];
        Map<Integer, ArrayList<Integer>> g = new HashMap<>();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int neighbor : graph[i]) {
                g.computeIfAbsent(neighbor, v -> new ArrayList<>()).add(i);
            }
            outdegree[i] += graph[i].length;
            if (outdegree[i] == 0) {
                deque.offer(i);
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!deque.isEmpty()) {
            int poll = deque.poll();
            flag[poll] = true;
            if (g.containsKey(poll)) {
                for (int neighbor : g.get(poll)) {
                    outdegree[neighbor]--;
                    if (outdegree[neighbor] == 0) {
                        deque.offer(neighbor);
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (flag[i]) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindEventualSafeStates f = new FindEventualSafeStates();
        assert "[2, 4, 5, 6]".equals(f.eventualSafeNodes(new int[][]{{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}}).toString());
        assert "[4]".equals(f.eventualSafeNodes(new int[][]{{1, 2, 3, 4}, {1, 2}, {3, 4}, {0, 4}, {}}).toString());
    }
}
