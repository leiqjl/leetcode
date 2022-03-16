package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1514. Path with Maximum Probability - Medium
 */
public class PathWithMaximumProbability {

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        LinkedList<double[]>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int v = edges[i][0];
            int w = edges[i][1];
            double p = succProb[i];
            graph[v].add(new double[]{w, p});
            graph[w].add(new double[]{v, p});
        }
        double[] prob = new double[n];
        Arrays.fill(prob, 0);
        prob[start] = 1;
        Queue<double[]> q = new ArrayDeque<>();
        q.add(new double[]{start, prob[start]});
        while (!q.isEmpty()) {
            double[] pair = q.remove();
            for (double[] edge : graph[(int) pair[0]]) {
                int s = (int) edge[0];
                double p = edge[1] * pair[1];
                if (p <= prob[s]) {
                    continue;
                }
                prob[s] = p;
                if (s == end) {
                    continue;
                }
                q.add(new double[]{s, p});
            }
        }
        return prob[end];
    }
}
