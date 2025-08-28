package com.leiqjl;

import java.util.ArrayList;
import java.util.List;

/**
 * 3446. Sort Matrix by Diagonals - Medium
 * You are given an n x n square matrix of integers grid. Return the matrix such that:
 *
 * · The diagonals in the bottom-left triangle (including the middle diagonal) are sorted in non-increasing order.
 * · The diagonals in the top-right triangle are sorted in non-decreasing order.
 *
 */
public class SortMatrixByDiagonals {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; i + j < n; j++) {
                list.add(grid[i + j][i]);
            }
            list.sort((a, b) -> b - a);
            for (int j = 0; i + j < n; j++) {
                grid[i + j][i] = list.get(j);
            }
        }
        for (int j = 1; j < n; j++) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i + j < n; i++) {
                list.add(grid[i][i + j]);
            }
            list.sort((a, b) -> a - b);
            for (int i = 0; i + j < n; i++) {
                grid[i][i + j] = list.get(i);
            }
        }
        return grid;
    }

}
