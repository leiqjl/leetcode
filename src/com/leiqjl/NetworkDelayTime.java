package com.leiqjl;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 743. Network Delay Time - Medium
 * You are given a network of n nodes, labeled from 1 to n.
 * You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node,
 * and wi is the time it takes for a signal to travel from source to target.
 * <p>
 * We will send a signal from a given node k. Return the time it takes for all the n nodes to receive the signal.
 * If it is impossible for all the n nodes to receive the signal, return -1.
 */
public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        LinkedList<int[]>[] graph = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] t : times) {
            int v = t[0];
            int w = t[1];
            int time = t[2];
            graph[v].add(new int[]{w, time});
        }
        int[] distTo = new int[n + 1];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        distTo[k] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{k, 0});
        while (!q.isEmpty()) {
            int[] pair = q.remove();
            for (int[] edge : graph[pair[0]]) {
                int i = edge[0];
                int time = pair[1] + edge[1];
                if (time >= distTo[i]) {
                    continue;
                }
                distTo[i] = time;
                q.add(new int[]{i, time});
            }
        }
        int result = -1;
        for (int i = 1; i <= n; i++) {
            if (i == k) {
                continue;
            }
            if (distTo[i] == Integer.MAX_VALUE) {
                return -1;
            }
            if (distTo[i] > result) {
                result = distTo[i];
            }
        }
        return result;
    }

    public int networkDelayTimeDFS(int[][] times, int n, int k) {
        LinkedList<int[]>[] graph = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] t : times) {
            int v = t[0];
            int w = t[1];
            int time = t[2];
            graph[v].add(new int[]{w, time});
        }
        int[] distTo = new int[n + 1];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        dfs(graph, k, 0, distTo);
        int result = -1;
        for (int i = 1; i <= n; i++) {
            if (i == k) {
                continue;
            }
            if (distTo[i] == Integer.MAX_VALUE) {
                return -1;
            }
            if (distTo[i] > result) {
                result = distTo[i];
            }
        }
        return result;
    }
    private void dfs(LinkedList<int[]>[] graph, int s, int time, int[] distTo) {
        if (time >= distTo[s]) {
            return;
        }
        distTo[s] = time;
        for (int[] edge : graph[s]) {
            int newTime = time + edge[1];
            dfs(graph, edge[0], newTime, distTo);
        }
    }

    public static void main(String[] args) {
        NetworkDelayTime n = new NetworkDelayTime();
        //Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
        //Output: 2
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        assert n.networkDelayTime(times, 4, 2) == 2;
        assert n.networkDelayTimeDFS(times, 4, 2) == 2;

        //Input: times = [[1,2,1]], n = 2, k = 1
        //Output: 1
        int[][] times1 = {{1, 2, 1}};
        assert  n.networkDelayTime(times1, 2, 1) == 1;
        assert  n.networkDelayTimeDFS(times1, 2, 1) == 1;

    }
}
