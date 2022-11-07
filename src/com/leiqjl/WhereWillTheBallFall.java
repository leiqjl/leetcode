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
                int next = s + grid[j][s];
                if (next < 0 || next == n || grid[j][s] != grid[j][next]) {
                    s = -1;
                    break;
                }
                s = next;
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
