package com.leiqjl;

/**
 * 48. Rotate Image - Medium
 * <p>
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 * <p>
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 */
public class RotateImage {
    //up to down -> symmetry
    public void rotate(int[][] matrix) {
        int begin = 0, end = matrix.length - 1;
        while (begin < end) {
            int[] tmp = matrix[begin];
            matrix[begin++] = matrix[end];
            matrix[end--] = tmp;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
