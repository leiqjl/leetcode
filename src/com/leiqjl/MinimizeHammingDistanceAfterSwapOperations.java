package com.leiqjl;

import java.util.HashMap;
import java.util.Map;

/**
 * 1722. Minimize Hamming Distance After Swap Operations - Medium
 * You are given two integer arrays, source and target, both of length n.
 * You are also given an array allowedSwaps where each allowedSwaps[i] = [ai, bi] indicates that you are allowed to swap the elements at index ai and index bi (0-indexed) of array source.
 * Note that you can swap elements at a specific pair of indices multiple times and in any order.
 * <p>
 * The Hamming distance of two arrays of the same length, source and target, is the number of positions where the elements are different. Formally, it is the number of indices i for 0 <= i <= n-1 where source[i] != target[i] (0-indexed).
 * <p>
 * Return the minimum Hamming distance of source and target after performing any amount of swap operations on array source.
 *
 */
public class MinimizeHammingDistanceAfterSwapOperations {
    private int[] parent;

    private int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    private void union(int p, int q) {
        p = find(p);
        q = find(q);
        if (p < q) {
            parent[q] = p;
        } else {
            parent[p] = q;
        }
    }

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        parent = new int[n];
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int[] swap : allowedSwaps) {
            union(swap[0], swap[1]);
        }
        for (int i = 0; i < n; i++) {
            int p = find(i);
            map.putIfAbsent(p, new HashMap<>());
            Map<Integer, Integer> countMap = map.computeIfAbsent(p, k -> new HashMap<>());
            countMap.put(source[i], countMap.getOrDefault(source[i], 0) + 1);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int p = find(i);
            Map<Integer, Integer> countMap = map.get(p);
            int count = countMap.getOrDefault(target[i], 0);
            if (count > 0) {
                countMap.put(target[i], count - 1);
            } else {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MinimizeHammingDistanceAfterSwapOperations m = new MinimizeHammingDistanceAfterSwapOperations();
        //Input: source = [1,2,3,4], target = [2,1,4,5], allowedSwaps = [[0,1],[2,3]]
        //Output: 1
        assert m.minimumHammingDistance(new int[]{1, 2, 3, 4}, new int[]{2, 1, 4, 5}, new int[][]{{0, 1}, {2, 3}}) == 1;
        //Input: source = [1,2,3,4], target = [1,3,2,4], allowedSwaps = []
        //Output: 2
        assert m.minimumHammingDistance(new int[]{1, 2, 3, 4}, new int[]{1, 3, 2, 4}, new int[][]{}) == 2;
        //Input: source = [5,1,2,4,3], target = [1,5,4,2,3], allowedSwaps = [[0,4],[4,2],[1,3],[1,4]]
        //Output: 0
        assert m.minimumHammingDistance(new int[]{5, 1, 2, 4, 3}, new int[]{1, 5, 4, 2, 3}, new int[][]{{0, 4}, {4, 2}, {1, 3}, {1, 4}}) == 0;
    }
}
