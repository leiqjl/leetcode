package com.leiqjl;

import java.util.*;

/**
 * 3373. Maximize the Number of Target Nodes After Connecting Trees II - Hard
 */
public class MaximizeTheNumberOfTargetNodesAfterConnectingTreesII {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;
        int[] colors1 = new int[n];
        int[] colors2 = new int[m];
        int evenCount1 = countNodesBFS(edges1, n, 0, colors1);
        int oddCount1 = n - evenCount1;
        int oddCount2 = countNodesBFS(edges2, m, 1, colors2);
        int evenCount2 = m - oddCount2;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = (colors1[i] == 0 ? evenCount1 : oddCount1) + Math.max(evenCount2, oddCount2);
        }
        return ans;
    }

    private int countNodesBFS(int[][] edges, int n, int even, int[] colors) {
        int count = 0;
        List<List<Integer>> graph = buildGraph(n, edges);
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, -1, 0});
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int[] arr = queue.poll();
                int cur = arr[0];
                int pre = arr[1];
                int curEven = arr[2];
                colors[cur] = curEven;
                if (curEven == even) {
                    count++;
                }
                for (int next : graph.get(cur)) {
                    if (next == pre) {
                        continue;
                    }
                    queue.offer(new int[]{next, cur, 1 - curEven});
                }
            }
        }
        return count;
    }

    private List<List<Integer>> buildGraph(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }

    public static void main(String[] args) {
        MaximizeTheNumberOfTargetNodesAfterConnectingTreesII m = new MaximizeTheNumberOfTargetNodesAfterConnectingTreesII();
        //Input: edges1 = [[0,1],[0,2],[2,3],[2,4]], edges2 = [[0,1],[0,2],[0,3],[2,7],[1,4],[4,5],[4,6]]
        //Output: [8,7,7,8,8]
        assert Arrays.equals(m.maxTargetNodes(
                        new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}},
                        new int[][]{{0, 1}, {0, 2}, {0, 3}, {2, 7}, {1, 4}, {4, 5}, {4, 6}}),
                new int[]{8, 7, 7, 8, 8});
        //Input: edges1 = [[0,1],[0,2],[0,3],[0,4]], edges2 = [[0,1],[1,2],[2,3]]
        //Output: [3,6,6,6,6]
        assert Arrays.equals(m.maxTargetNodes(new int[][]{{0, 1}, {0, 2}, {0, 3}, {0, 4}}, new int[][]{{0, 1}, {1, 2}, {2, 3}}), new int[]{3, 6, 6, 6, 6});
        assert Arrays.equals(m.maxTargetNodes(new int[][]{{0, 1}}, new int[][]{{0, 1}, {1, 2}}), new int[]{3, 3});
    }
}
