package com.leiqjl;

import java.util.Arrays;

/**
 * 3108. Minimum Cost Walk in Weighted Graph - Hard
 */
public class MinimumCostWalkInWeightedGraph {

    private int[] parent;
    private int[] and;

    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    private int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    private void union(int p, int q, int w) {
        p = find(p);
        q = find(q);
        if (p < q) {
            parent[q] = p;
        } else {
            parent[p] = q;
        }
        and[p] = and[p] & and[q] & w;
        and[q] = and[p];
    }

    //union find
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        parent = new int[n];
        and = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            and[i] = Integer.MAX_VALUE;
        }
        for (int[] edge : edges) {
            union(edge[0], edge[1], edge[2]);
        }
        int[] res = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            if (connected(query[i][0], query[i][1])) {
                res[i] = and[find(query[i][0])];
            } else {
                res[i] = -1;
            }
        }
        return res;
    }


    public static void main(String[] args) {

        MinimumCostWalkInWeightedGraph m = new MinimumCostWalkInWeightedGraph();
        //Input: n = 5, edges = [[0,1,7],[1,3,7],[1,2,1]], query = [[0,3],[3,4]
        //Output: [1,-1]
        //To achieve the cost of 1 in the first query, we need to move on the following edges: 0->1 (weight 7), 1->2 (weight 1), 2->1 (weight 1), 1->3 (weight 7).
        //7&1&1&7=1
        //In the second query, there is no walk between nodes 3 and 4, so the answer is -1.
        assert Arrays.equals(m.minimumCost(5, new int[][]{{0, 1, 7}, {1, 3, 7}, {1, 2, 1}}, new int[][]{{0, 3}, {3, 4}}), new int[]{1, -1});
        //Input: n = 3, edges = [[0,2,7],[0,1,15],[1,2,6],[1,2,1]], query = [[1,2]]
        //Output: [0]
        //To achieve the cost of 0 in the first query, we need to move on the following edges: 1->2 (weight 1), 2->1 (weight 6), 1->2 (weight 1).
        //1&6&1=0
        //1  0001
        //6  0110
        //7  0111
        //15 1111
        assert Arrays.equals(m.minimumCost(3, new int[][]{{0, 2, 7}, {0, 1, 15}, {1, 2, 6}, {1, 2, 1}}, new int[][]{{1, 2}}), new int[]{0});
    }
}
