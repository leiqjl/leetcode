package com.leiqjl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 2033. Minimum Operations to Make a Uni-Value Grid - Medium
 * You are given a 2D integer grid of size m x n and an integer x. In one operation, you can add x to or subtract x from any element in the grid.
 * <p>
 * A uni-value grid is a grid where all the elements of it are equal.
 * <p>
 * Return the minimum number of operations to make the grid uni-value. If it is not possible, return -1.
 */
public class MinimumOperationsToMakeAUniValueGrid {
    //Constraints:
    //
    //m == grid.length
    //n == grid[i].length
    //1 <= m, n <= 10^5
    //1 <= m * n <= 10^5
    //1 <= x, grid[i][j] <= 10^4
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int[] freq = new int[100001];
        int remainder = grid[0][0] % x;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] % x != remainder) {
                    return -1;
                }
                freq[grid[i][j]]++;
            }
        }
        int mid = (m * n) / 2;
        int median = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                if (mid < freq[i]) {
                    median = i;
                    break;
                }
                mid -= freq[i];
            }
        }
        int res = 0;
        for (int i = 0; i < median; i++) {
            res += freq[i] * (median - i) / x;
        }
        for (int i = median + 1; i < freq.length; i++) {
            res += freq[i] * (i - median) / x;
        }
        return res;
    }

    public int minOperations1(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        List<Integer> list = new ArrayList<>();
        int remainder = grid[0][0] % x;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] % x != remainder) {
                    return -1;
                }
                list.add(grid[i][j]);
            }
        }
        list.sort(Comparator.comparingInt(a -> a));
        int mid = list.size() / 2;
        int result = 0;
        for (int num : list) {
            result += (Math.abs(num - list.get(mid)) / x);
        }
        return result;
    }

    public static void main(String[] args) {
        MinimumOperationsToMakeAUniValueGrid m = new MinimumOperationsToMakeAUniValueGrid();
        //Input: grid = [[2,4],[6,8]], x = 2
        //Output: 4
        assert m.minOperations(new int[][]{{2, 4}, {6, 8}}, 2) == 4;
        //Input: grid = [[1,5],[2,3]], x = 1
        //Output: 5
        assert m.minOperations(new int[][]{{1, 5}, {2, 3}}, 1) == 5;
        //Input: grid = [[1,2],[3,4]], x = 2
        //Output: -1
        assert m.minOperations(new int[][]{{1, 2}, {3, 4}}, 2) == -1;
        //[[980,476,644,56],[644,140,812,308],[812,812,896,560],[728,476,56,812]]
        assert m.minOperations(new int[][]{{980, 476, 644, 56}, {644, 140, 812, 308}, {812, 812, 896, 560}, {728, 476, 56, 812}}, 84) == 45;
    }
}
