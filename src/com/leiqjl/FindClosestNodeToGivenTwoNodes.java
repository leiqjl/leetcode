package com.leiqjl;

import java.util.Arrays;

/**
 * 2359. Find Closest Node to Given Two Nodes - Medium
 */
public class FindClosestNodeToGivenTwoNodes {

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        Arrays.fill(dist1, -1);
        Arrays.fill(dist2, -1);
        dfs(edges, node1, dist1);
        dfs(edges, node2, dist2);
        int min = Integer.MAX_VALUE;
        int result = -1;
        for (int i = 0; i < n; i++) {
            if (dist1[i] >= 0 && dist2[i] >= 0 && Math.max(dist1[i], dist2[i]) < min) {
                min = Math.max(dist1[i], dist2[i]);
                result = i;
            }
        }
        return result;
    }

    private void dfs(int[] edges, int node, int[] dist) {
        int d = 0;
        while (node != -1 && dist[node] == -1) {
            dist[node] = d;
            node = edges[node];
            d++;
        }
    }

    public static void main(String[] args) {
        FindClosestNodeToGivenTwoNodes f = new FindClosestNodeToGivenTwoNodes();
        assert f.closestMeetingNode(new int[]{2, 2, 3, -1}, 0, 1) == 2;
        assert f.closestMeetingNode(new int[]{1, 2, -1}, 0, 2) == 2;
    }
}
