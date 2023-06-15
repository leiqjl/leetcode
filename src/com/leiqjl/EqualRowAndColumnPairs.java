package com.leiqjl;

import java.util.HashMap;

/**
 * 2352. Equal Row and Column Pairs - Medium
 */
public class EqualRowAndColumnPairs {
    //Constraints:
    //
    //n == grid.length == grid[i].length
    //1 <= n <= 200
    //1 <= grid[i][j] <= 105
    public int equalPairs(int[][] grid) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(grid[i][j]).append("-");
            }
            String str = sb.toString();
            hashMap.put(str, hashMap.getOrDefault(str, 0) + 1);
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(grid[i][j]).append("-");
            }
            String str = sb.toString();

            res += hashMap.getOrDefault(str, 0);
        }
        return res;
    }

}
