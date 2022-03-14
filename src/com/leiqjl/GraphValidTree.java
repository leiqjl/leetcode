package com.leiqjl;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 261. Graph Valid Tree - Medium
 * <p>
 * Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes),
 * write a function to check whether these edges make up a valid tree.
 */
public class GraphValidTree {

    /**
     * Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
     * Output: true
     * Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
     * Output: false
     */
    public boolean validTree(int n, int[][] edges) {
        boolean[] visit = new boolean[n];
        int count = 0;
        LinkedList<Integer>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        while (!q.isEmpty()) {
            int s = q.remove();
            if (visit[s]) {
                return false;
            }
            visit[s] = true;
            count++;
            for (int i : graph[s]) {
                q.add(i);
                graph[i].remove(Integer.valueOf(s));
            }
        }
        return count == n;
    }

    public boolean validTreeDFS(int n, int[][] edges) {
        int[] visit = new int[n];
        LinkedList<Integer>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        if (!dfs(graph, visit, 0)) {
            return false;
        }
        for (int i : visit) {
            if (i == 0) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(LinkedList<Integer>[] graph, int[] visit, int s) {
        if (visit[s] == 2) {
            return false;
        }
        if (visit[s] == 1) {
            return true;
        }
        visit[s] = 2;
        for (int i : graph[s]) {
            graph[i].remove(Integer.valueOf(s));
            if (!dfs(graph, visit, i)) {
                return false;
            }
        }
        visit[s] = 1;
        return true;
    }

    public boolean validTreeUF(int n, int[][] edges) {
        UF uf = new UF(n);
        for (int[] edge : edges) {
            int v = edge[0];
            int w = edge[1];
            if (uf.connected(v, w)) {
                return false;
            }
            uf.union(v, w);
        }
        return uf.count == 1;
    }


    public static void main(String[] args) {
        GraphValidTree g = new GraphValidTree();
        //true n=5
        int[][] edges1 = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        assert g.validTree(5, edges1);
        assert g.validTreeDFS(5, edges1);
        assert g.validTreeUF(5, edges1);
        //false n=5
        int[][] edges2 = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
        assert !g.validTree(5, edges2);
        assert !g.validTreeDFS(5, edges2);
        assert !g.validTreeUF(5, edges2);
        int[][] edges3 = {{0, 1}, {0, 2}, {3, 4}};
        assert !g.validTree(5, edges3);
        assert !g.validTreeDFS(5, edges3);
        assert !g.validTreeUF(5, edges3);
    }
}
