package com.leiqjl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 1584. Min Cost to Connect All Points - Medium
 */
public class MinCostToConnectAllPoints {
    //Prims
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int xi = points[i][0], yi = points[i][1];
                int xj = points[j][0], yj = points[j][1];
                pq.add(new int[]{i, j, Math.abs(xi - xj) + Math.abs(yi - yj)});
            }
        }

        UF uf = new UF(n);
        int mst = 0;
        while (!pq.isEmpty() && n > 1) {
            int[] edge = pq.poll();
            if (uf.connected(edge[0], edge[1])) {
                continue;
            }
            n--;
            uf.union(edge[0], edge[1]);
            mst += edge[2];
        }
        return mst;
    }

    public int minCostConnectPoints1(int[][] points) {
        int n = points.length;
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int xi = points[i][0], yi = points[i][1];
                int xj = points[j][0], yj = points[j][1];
                edges.add(new int[]{i, j, Math.abs(xi - xj) + Math.abs(yi - yj)});
            }
        }
        edges.sort(Comparator.comparingInt(a -> a[2]));
        UF uf = new UF(n);
        int mst = 0;
        for (int[] edge : edges) {
            if (uf.connected(edge[0], edge[1])) {
                continue;
            }
            uf.union(edge[0], edge[1]);
            mst += edge[2];
        }
        return uf.count() == 1 ? mst : -1;
    }

    public static void main(String[] args) {
        //Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
        //Output: 20
        MinCostToConnectAllPoints m = new MinCostToConnectAllPoints();
        int[][] a = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        assert m.minCostConnectPoints(a) == 20;

    }
}
