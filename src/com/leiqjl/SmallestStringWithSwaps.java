package com.leiqjl;

import java.util.*;

/**
 * 1202. Smallest String With Swaps - Medium
 */
public class SmallestStringWithSwaps {
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
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (List<Integer> pair : pairs) {
            int p = pair.get(0);
            int q = pair.get(1);
            union(p, q);
        }
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int p = find(i);
            map.putIfAbsent(p, new PriorityQueue<>());
            map.get(p).add(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int p = find(i);
            sb.append(map.get(p).poll());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SmallestStringWithSwaps t = new SmallestStringWithSwaps();
        //Input: s = "dcab", pairs = [[0,3],[1,2]]
        //Output: "bacd"
        String s = "dcab";
        List<List<Integer>> pairs = Arrays.asList(Arrays.asList(0, 3), Arrays.asList(1, 2));
        System.out.println(t.smallestStringWithSwaps(s, pairs));
        //Input: s = "dcab", pairs = [[0,3],[1,2],[0,2]]
        //Output: "abcd"
        pairs = Arrays.asList(Arrays.asList(0, 3), Arrays.asList(1, 2), Arrays.asList(0, 2));
        System.out.println(t.smallestStringWithSwaps(s, pairs));
    }
}
