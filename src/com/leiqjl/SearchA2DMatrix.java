package com.leiqjl;

/**
 * 74. Search a 2D Matrix - Medium
 * <p>
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
 * - Integers in each row are sorted from left to right.
 * - The first integer of each row is greater than the last integer of the previous row.
 */
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int begin = 0, end = rows * cols - 1;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            int midVal = matrix[mid / cols][mid % cols];
            if (midVal == target) {
                return true;
            } else if (midVal < target) {
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}
