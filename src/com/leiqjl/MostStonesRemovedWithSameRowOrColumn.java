package com.leiqjl;

import java.util.HashMap;
import java.util.Map;

/**
 * 947. Most Stones Removed with Same Row or Column - Medium
 */
public class MostStonesRemovedWithSameRowOrColumn {

    Map<Integer, Integer> parent = new HashMap<>();
    int count = 0;

    public int removeStones(int[][] stones) {
        for (int[] stone : stones) {
            union(stone[0], stone[1] + 10000);
        }
        return stones.length - count;
    }

    private void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP != rootQ) {
            parent.put(rootP, rootQ);
            count--;
        }
    }

    private int find(int s) {
        if (!parent.containsKey(s)) {
            parent.put(s, s);
            count++;
        }
        if (s != parent.get(s)) {
            parent.put(s, find(parent.get(s)));
        }
        return parent.get(s);
    }

}
