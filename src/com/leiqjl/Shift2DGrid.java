package com.leiqjl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 1260. Shift 2D Grid - Easy
 */
public class Shift2DGrid {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int gridCount = m * n;
        int begin = gridCount - k % gridCount;
        LinkedList<List<Integer>> result = new LinkedList<>();
        for (int i = begin; i < begin + gridCount; i++) {
            int col = (i % gridCount) / n;
            int row = (i % gridCount) % n;
            if ((i - begin) % n == 0) {
                result.add(new ArrayList<>(n));
            }
            result.getLast().add(grid[col][row]);
        }
        return result;
    }
}
