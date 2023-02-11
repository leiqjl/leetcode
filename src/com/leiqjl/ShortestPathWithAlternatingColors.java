package com.leiqjl;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1129. Shortest Path with Alternating Colors - Medium
 */
public class ShortestPathWithAlternatingColors {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        LinkedList<Integer>[][] graph = new LinkedList[2][n];
        for (int i = 0; i < n; i++) {
            graph[0][i] = new LinkedList<>();
            graph[1][i] = new LinkedList<>();
        }
        // 1red 0blue
        for (int[] redEdge : redEdges) {
            graph[0][redEdge[0]].add(redEdge[1]);
        }
        for (int[] blueEdge : blueEdges) {
            graph[1][blueEdge[0]].add(blueEdge[1]);
        }
        int[][] tempRes = new int[2][n];
        for (int i = 1; i < n; i++) {
            tempRes[0][i] = Integer.MAX_VALUE;
            tempRes[1][i] = Integer.MAX_VALUE;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 1});
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] temp = queue.remove();
            int cur = temp[0];
            int color = temp[1];
            for (int neighbor : graph[1 - color][cur]) {
                if (tempRes[1 - color][neighbor] == Integer.MAX_VALUE) {
                    tempRes[1 - color][neighbor] = 1 + tempRes[color][cur];
                    queue.add(new int[]{neighbor, 1 - color});
                }
            }
        }
        int[] result = new int[n];
        for (int i = 1; i < n; i++) {
            int min = Math.min(tempRes[0][i], tempRes[1][i]);
            result[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return result;
    }
}
