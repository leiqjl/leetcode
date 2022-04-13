package com.leiqjl;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix - Medium
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int total = m * n;
        int left = 0, up = 0, right = n - 1, down = m - 1;
        List<Integer> res = new ArrayList<>(total);
        while (res.size() < total) {
            if (up <= down) {
                for (int j = left; j <= right; j++) {
                    res.add(matrix[up][j]);
                }
                up++;
            }
            if (left <= right) {
                for (int i = up; i <= down; i++) {
                    res.add(matrix[i][right]);
                }
                right--;
            }
            if (up <= down) {
                for (int j = right; j >= left; j--) {
                    res.add(matrix[down][j]);
                }
                down--;
            }
            if (left <= right) {
                for (int i = down; i >= up; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SpiralMatrix s = new SpiralMatrix();
        //Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
        //Output: [1,2,3,6,9,8,7,4,5]
        int[][] m = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        assert s.spiralOrder(m).toString().equals("[1, 2, 3, 6, 9, 8, 7, 4, 5]");
        //Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
        //Output: [1,2,3,4,8,12,11,10,9,5,6,7]
        int[][] m1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        assert s.spiralOrder(m1).toString().equals("[1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]");
    }
}
