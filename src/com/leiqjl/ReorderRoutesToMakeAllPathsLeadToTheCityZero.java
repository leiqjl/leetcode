package com.leiqjl;

import java.util.*;

/**
 * 1466. Reorder Routes to Make All Paths Lead to the City Zero - Medium
 */
public class ReorderRoutesToMakeAllPathsLeadToTheCityZero {
    public int minReorder(int n, int[][] connections) {
        Map<Integer, ArrayList<int[]>> graph = new HashMap<>();
        for (int[] connection : connections) {
            graph.computeIfAbsent(connection[0], v -> new ArrayList<>()).add(new int[]{connection[1], 1});
            graph.computeIfAbsent(connection[1], v -> new ArrayList<>()).add(new int[]{connection[0], 0});
        }
        int result = 0;
        boolean[] visited = new boolean[n];
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(0);
        visited[0] = true;
        while (!deque.isEmpty()) {
            int poll = deque.poll();
            if (!graph.containsKey(poll)) {
                continue;
            }
            for (int[] c : graph.get(poll)) {
                if (visited[c[0]]) {
                    continue;
                }
                visited[c[0]] = true;
                result += c[1];
                deque.offer(c[0]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ReorderRoutesToMakeAllPathsLeadToTheCityZero r = new ReorderRoutesToMakeAllPathsLeadToTheCityZero();
        assert r.minReorder(6, new int[][]{{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}}) == 3;
        assert r.minReorder(5, new int[][]{{1, 0}, {1, 2}, {3, 2}, {3, 4}}) == 2;
        assert r.minReorder(3, new int[][]{{1, 0}, {2, 0}}) == 0;
    }
}
