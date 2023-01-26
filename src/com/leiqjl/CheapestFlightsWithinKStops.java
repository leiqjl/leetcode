package com.leiqjl;

import java.util.*;

/**
 * 787. Cheapest Flights Within K Stops - Medium
 */
public class CheapestFlightsWithinKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, LinkedList<int[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.computeIfAbsent(flight[0], v -> new LinkedList<>()).add(new int[]{flight[1], flight[2]});
        }
        int[] price = new int[n];
        Arrays.fill(price, Integer.MAX_VALUE);
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0});
        int num = k + 1;
        while (num > 0 && !queue.isEmpty()) {
            for (int size = queue.size(); size > 0; size--) {
                int[] arr = queue.poll();
                int s = arr[0];
                int p = arr[1];
                if (!graph.containsKey(s)) {
                    continue;
                }
                for (int[] edge : graph.get(s)) {
                    int neighbour = edge[0];
                    int neighbourPrice = edge[1];
                    if (neighbourPrice + p >= price[neighbour]) {
                        continue;
                    }
                    price[neighbour] = neighbourPrice + p;
                    queue.offer(new int[]{neighbour, price[neighbour]});
                }
            }
            num--;
        }
        return price[dst] == Integer.MAX_VALUE ? -1 : price[dst];
    }

}
