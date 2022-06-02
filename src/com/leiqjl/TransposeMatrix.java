package com.leiqjl;

import java.util.Arrays;

/**
 * 867. Transpose Matrix - Easy
 * <p>
 * Given a 2D integer array matrix, return the transpose of matrix.
 * <p>
 * The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.
 */
public class TransposeMatrix {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[j][i] = matrix[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TransposeMatrix t = new TransposeMatrix();
        //Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
        //Output: [[1,4,7],[2,5,8],[3,6,9]]
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.deepToString(t.transpose(matrix)));
        //Input: matrix = [[1,2,3],[4,5,6]]
        //Output: [[1,4],[2,5],[3,6]]
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(Arrays.deepToString(t.transpose(matrix1)));
        int[][] matrix2 = {{7, 2}};
        System.out.println(Arrays.deepToString(t.transpose(matrix2)));
    }
}
