package com.leiqjl;

import java.util.Arrays;

/**
 * 2976. Minimum Cost to Convert String I - Medium
 */
public class MinimumCostToConvertStringI {
    //Floyd-Warshall algorithm
    //n26
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] misCost = new long[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(misCost[i], Long.MAX_VALUE);
        }
        for (int i = 0; i < original.length; i++) {
            int from = original[i] - 'a';
            int to = changed[i] - 'a';
            misCost[from][to] = Math.min(misCost[from][to], cost[i]);
        }
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (misCost[i][k] < Long.MAX_VALUE && misCost[k][j] < Long.MAX_VALUE) {
                        misCost[i][j] = Math.min(misCost[i][j], misCost[i][k] + misCost[k][j]);
                    }
                }
            }
        }
        long totalCost = 0;
        for (int i = 0; i < source.length(); i++) {
            int from = source.charAt(i) - 'a';
            int to = target.charAt(i) - 'a';
            if (from != to) {
                if (misCost[from][to] == Long.MAX_VALUE) {
                    return -1;
                }
                totalCost += misCost[from][to];
            }
        }
        return totalCost;
    }
}
