package com.leiqjl;

import java.util.*;

/**
 * 2421. Number of Good Paths - Hard
 */
public class NumberOfGoodPaths {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], v -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], v -> new ArrayList<>()).add(edge[0]);
        }
        TreeMap<Integer, List<Integer>> valueNodesMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            valueNodesMap.computeIfAbsent(vals[i], v -> new ArrayList<>()).add(i);
        }
        UF uf = new UF(n);
        int result = 0;
        for (int val : valueNodesMap.keySet()) {
            List<Integer> sameValueList = valueNodesMap.get(val);
            for (int p : sameValueList) {
                if (!graph.containsKey(p)) {
                    continue;
                }
                for (int q : graph.get(p)) {
                    if (vals[p] >= vals[q]) {
                        uf.union(p, q);
                    }
                }

            }

            result += sameValueList.size();
            Map<Integer, Integer> map = new HashMap<>();
            for (int p : sameValueList) {
                int pp = uf.find(p);
                map.put(pp, map.getOrDefault(pp, 0) + 1);
            }
            for (int size : map.values()) {
                result += size * (size-1) / 2;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        NumberOfGoodPaths n = new NumberOfGoodPaths();
        assert n.numberOfGoodPaths(new int[]{1,3,2,1,3}, new int[][]{{0,1},{0,2},{2,3},{2,4}}) == 6;
    }

}

