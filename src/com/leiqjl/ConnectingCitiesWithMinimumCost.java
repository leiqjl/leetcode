package com.leiqjl;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1135. Connecting Cities With Minimum Cost - Medium
 */
public class ConnectingCitiesWithMinimumCost {

    public int minimumCost(int n, int[][] connections) {
        Arrays.sort(connections, Comparator.comparingInt(a -> a[2]));
        UF uf = new UF(n);
        int mst = 0;
        for (int[] a : connections) {
            int v = a[0] - 1;
            int w = a[1] - 1;
            if (uf.connected(v, w)) {
                continue;
            }
            uf.union(v, w);
            mst += a[2];
        }
        return uf.count() == 1 ? mst : -1;
    }
}
