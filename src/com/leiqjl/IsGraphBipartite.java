package com.leiqjl;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 785. Is Graph Bipartite? - Medium
 * There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1.
 * You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to. More formally, for each v in graph[u], there is an undirected edge between node u and node v. The graph has the following properties:
 *
 * - There are no self-edges (graph[u] does not contain u).
 * - There are no parallel edges (graph[u] does not contain duplicate values).
 * - If v is in graph[u], then u is in graph[v] (the graph is undirected).
 * - The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
 *
 * A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the graph connects a node in set A and a node in set B.
 *
 * Return true if and only if it is bipartite.
 */
public class IsGraphBipartite {

    //BFS
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (color[i] != 0) {
                continue;
            }
            color[i] = 1;
            q.add(i);
            while (!q.isEmpty()) {
                int s = q.remove();
                for (int c : graph[s]) {
                    if (color[c] == 0) {
                        color[c] = - color[s];
                        q.add(c);
                    } else if (color[c] == color[s]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isBipartiteDFS(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            if (color[i] != 0) {
                continue;
            }
            color[i] = 1;
            if (!dfs(graph, i, color)) {
                return false;
            }
        }
        return true;
    }
    private boolean dfs(int[][] graph, int s, int[] color) {
        for (int c : graph[s]) {
            if (color[c] == 0) {
                color[c] = -color[s];
                if (!dfs(graph, c, color)) {
                    return false;
                }
            } else if (color[c] == color[s]) {
                return false;
            }
        }
        return true;
    }
}
