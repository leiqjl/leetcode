package com.leiqjl;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 886. Possible Bipartition - Medium
 * <p>
 * We want to split a group of n people (labeled from 1 to n) into two groups of any size. Each person may dislike some other people, and they should not go into the same group.
 * <p>
 * Given the integer n and the array dislikes where dislikes[i] = [ai, bi] indicates that the person labeled ai does not like the person labeled bi,
 * return true if it is possible to split everyone into two groups in this way.
 */
public class PossibleBipartition {

    //bfs
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] color = new int[n];
        LinkedList<Integer>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] dislike : dislikes) {
            graph[dislike[0] - 1].add(dislike[1] - 1);
            graph[dislike[1] - 1].add(dislike[0] - 1);
        }
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
                        color[c] = -color[s];
                        q.add(c);
                    } else if (color[c] == color[s]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    //dfs
    public boolean possibleBipartitionDFS(int n, int[][] dislikes) {
        int[] color = new int[n];
        LinkedList<Integer>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] dislike : dislikes) {
            graph[dislike[0] - 1].add(dislike[1] - 1);
            graph[dislike[1] - 1].add(dislike[0] - 1);
        }
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

    private boolean dfs(LinkedList<Integer>[] graph, int s, int[] color) {
        for (int c : graph[s]) {
            if (color[c] == 0) {
                color[c] = -color[s];
                if (!dfs(graph, c, color)) {
                    return false;
                }
            } else if (color[c] == color[s])  {
                return false;
            }
        }
        return true;
    }
}
