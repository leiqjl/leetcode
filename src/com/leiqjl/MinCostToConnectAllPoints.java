package com.leiqjl;

import java.util.LinkedList;
import java.util.List;

/**
 * 1584. Min Cost to Connect All Points - Medium
 */
public class MinCostToConnectAllPoints {

    //Kruskal
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]> edges = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int xi = points[i][0], yi = points[i][1];
                int xj = points[i][0], yj = points[j][1];
                edges.add(new int[]{i, j, Math.abs(xi - xj) + Math.abs(yi - yj)});
            }
        }
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
}
