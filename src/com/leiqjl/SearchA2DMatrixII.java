package com.leiqjl;

/**
 * 240. Search a 2D Matrix II - Medium
 */
public class SearchA2DMatrixII {

    //m == matrix.length
    //n == matrix[i].length
    //1 <= n, m <= 300
    //-10^9 <= matrix[i][j] <= 10^9
    //All the integers in each row are sorted in ascending order.
    //All the integers in each column are sorted in ascending order.
    //-10^9 <= target <= 10^9
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = m - 1, j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] < target) {
                j++;
            } else if (matrix[i][j] > target) {
                i--;
            } else {
                return true;
            }
        }
        return false;
    }

}
