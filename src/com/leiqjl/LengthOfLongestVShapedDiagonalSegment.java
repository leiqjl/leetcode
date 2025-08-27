package com.leiqjl;

import java.util.Arrays;

/**
 * 3459. Length of Longest V-Shaped Diagonal Segment - Hard
 */
public class LengthOfLongestVShapedDiagonalSegment {
    private static int[][] DIRECTIONS = {{1, 1}, {1, -1}, {-1, -1}, {-1, 1}};

    public int lenOfVDiagonal(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][][] mem = new int[m][n][4][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    Arrays.fill(mem[i][j][k], -1);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        result = Math.max(result, dfs(grid, mem, i, j, m, n, k, 1, 2) + 1);
                    }
                }
            }
        }
        return result;
    }

    private int dfs(int[][] grid, int[][][][] mem, int i, int j, int m, int n, int d, int canTurn, int target) {
        int ni = i + DIRECTIONS[d][0];
        int nj = j + DIRECTIONS[d][1];
        if (ni < 0 || ni >= m || nj < 0 || nj >= n || grid[ni][nj] != target) {
            return 0;
        }
        if (mem[ni][nj][d][canTurn] != -1) {
            return mem[ni][nj][d][canTurn];
        }
        int len = dfs(grid, mem, ni, nj, m, n, d, canTurn, 2 - target);
        if (canTurn == 1) {
            len = Math.max(len, dfs(grid, mem, ni, nj, m, n, (d + 1) % 4, 0, 2 - target));
        }
        len++;
        mem[ni][nj][d][canTurn] = len;
        return len;
    }

    public static void main(String[] args) {
        LengthOfLongestVShapedDiagonalSegment l = new LengthOfLongestVShapedDiagonalSegment();
        //Input: grid = [[2,2,1,2,2],[2,0,2,2,0],[2,0,1,1,0],[1,0,2,2,2],[2,0,0,2,2]]
        //Output: 5
        assert l.lenOfVDiagonal(new int[][]{{2, 2, 1, 2, 2}, {2, 0, 2, 2, 0}, {2, 0, 1, 1, 0}, {1, 0, 2, 2, 2}, {2, 0, 0, 2, 2}}) == 5;
        //Input: grid = [[2,2,2,2,2],[2,0,2,2,0],[2,0,1,1,0],[1,0,2,2,2],[2,0,0,2,2]]
        //Output: 4
        assert l.lenOfVDiagonal(new int[][]{{2, 2, 2, 2, 2}, {2, 0, 2, 2, 0}, {2, 0, 1, 1, 0}, {1, 0, 2, 2, 2}, {2, 0, 0, 2, 2}}) == 4;
        //Input: grid = [[1,2,2,2,2],[2,2,2,2,0],[2,0,0,0,0],[0,0,2,2,2],[2,0,0,2,0]]
        //Output: 5
        assert l.lenOfVDiagonal(new int[][]{{1, 2, 2, 2, 2}, {2, 2, 2, 2, 0}, {2, 0, 0, 0, 0}, {0, 0, 2, 2, 2}, {2, 0, 0, 2, 0}}) == 5;
        //Input: grid = [[1]]
        //Output: 1
        assert l.lenOfVDiagonal(new int[][]{{1}}) == 1;
    }
}
