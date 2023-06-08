package com.leiqjl;

/**
 * 1351. Count Negative Numbers in a Sorted Matrix - Easy
 * Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise,
 * return the number of negative numbers in grid.
 */
public class CountNegativeNumbersInASortedMatrix {
    public int countNegatives(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int idx = n - 1;
        int count = 0;
        for (int i = 0; i < m; i++) {
            while (idx >= 0 && grid[i][idx] < 0) {
                idx--;
            }
            count += (n - 1 - idx);
        }
        return count;
    }

    public int countNegatives1(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            int idx = binarySearch(grid[i], 0, n - 1, -1);
            count += (n - idx);
        }
        return count;
    }

    private int binarySearch(int[] arr, int l, int r, int target) {
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] >= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        CountNegativeNumbersInASortedMatrix c = new CountNegativeNumbersInASortedMatrix();
        //Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
        //Output: 8
        //Explanation: There are 8 negatives number in the matrix.
        assert c.countNegatives(new int[][]{{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}}) == 8;
        //Input: grid = [[3,2],[1,0]]
        //Output: 0
        assert c.countNegatives(new int[][]{{3, 2}, {1, 0}}) == 0;
    }
}
