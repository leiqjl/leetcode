package com.leiqjl;

import java.util.HashMap;

/**
 * 3160. Find the Number of Distinct Colors Among the Balls - Medium
 */
public class FindTheNumberOfDistinctColorsAmongTheBalls {
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        int[] result = new int[n];
        HashMap<Integer, Integer> ballColorMap = new HashMap<>();
        HashMap<Integer, Integer> colorsMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];
            if (ballColorMap.containsKey(ball)) {
                int oldColor = ballColorMap.get(ball);
                int num = colorsMap.get(oldColor);
                if (num == 1) {
                    colorsMap.remove(oldColor);
                } else {
                    colorsMap.put(oldColor, num - 1);
                }

            }
            ballColorMap.put(ball, color);
            colorsMap.put(color, colorsMap.getOrDefault(color, 0) + 1);
            result[i] = colorsMap.size();
        }
        return result;
    }
}
