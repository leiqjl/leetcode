package com.leiqjl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 797. All Paths From Source to Target - Medium
 * <p>
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.
 * <p>
 * The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
 */
public class AllPathsFromSourceToTarget {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        traversal(graph, 0, path, result);
        return result;
    }

    private void traversal(int[][] graph, int curr, LinkedList<Integer> path, List<List<Integer>> result) {
        path.addLast(curr);
        int n = graph.length;
        if (curr == (n - 1)) {
            result.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }
        for (int child : graph[curr]) {
            traversal(graph, child, path, result);
        }
        path.removeLast();
    }
}
