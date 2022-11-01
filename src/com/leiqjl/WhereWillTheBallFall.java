package com.leiqjl;

import java.util.Arrays;

/**
 * 1706. Where Will the Ball Fall - Medium
 */
public class WhereWillTheBallFall {
    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int s = i;
            for (int j = 0; j < m; j++) {
                if (grid[j][s] == 1) {
                    if (s == n - 1 || grid[j][s + 1] == -1) {
                        s = -1;
                        break;
                    } else {
                        s += 1;
                    }
                } else {
                    if (s == 0 || grid[j][s - 1] == 1) {
                        s = -1;
                        break;
                    } else {
                        s -= 1;
                    }
                }
            }
            ans[i] = s;
        }
        return ans;
    }

    public static void main(String[] args) {
        WhereWillTheBallFall w = new WhereWillTheBallFall();
        int[][] grid = {{1, 1, 1, -1, -1}, {1, 1, 1, -1, -1}, {-1, -1, -1, 1, 1}, {1, 1, 1, 1, -1}, {-1, -1, -1, -1, -1}};
        System.out.println(Arrays.toString(w.findBall(grid)));
    }
}
