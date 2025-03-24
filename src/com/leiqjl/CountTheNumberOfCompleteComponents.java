package com.leiqjl;

import java.util.HashMap;
import java.util.Map;

/**
 * 2685. Count the Number of Complete Components - Medium
 */
public class CountTheNumberOfCompleteComponents {
    public int countCompleteComponents(int n, int[][] edges) {
        int count = 0;
        Map<Integer, Integer> edgeCount = new HashMap<>();
        UF uf = new UF(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        for (int[] edge : edges) {
            int p = uf.find(edge[0]);
            edgeCount.put(p, edgeCount.getOrDefault(p, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            if (uf.find(i) != i) {
                continue;
            }
            int size = uf.size[i];
            int e = (size * (size - 1)) / 2;
            if (edgeCount.getOrDefault(i, 0) == e) {
                count++;
            }
        }
        return count;
    }

    class UF {
        int[] parent;
        int[] size;
        int count;

        public UF(int n) {
            this.parent = new int[n];
            this.size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
            this.count = n;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ)
                return;
            //平衡树的高度
            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            count--;
        }

        public boolean connected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }

        public int find(int x) {
            while (parent[x] != x) {
                //路径压缩
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public int count() {
            return count;
        }
    }
}
