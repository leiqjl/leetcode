package com.leiqjl;

/**
 * 498. Diagonal Traverse - Medium
 */
public class DiagonalTraverse {

    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int i = 0, j = 0, k = 0;
        int[] result = new int[m * n];
        boolean up = true;
        while (k < m * n) {
            result[k] = mat[i][j];
            if (up) {
                if (j == n - 1) {
                    i++;
                    up = false;
                } else if (i == 0) {
                    j++;
                    up = false;
                } else {
                    i--;
                    j++;
                }
            } else {
                if (i == m - 1) {
                    j++;
                    up = true;
                } else if (j == 0) {
                    i++;
                    up = true;
                } else {
                    i++;
                    j--;
                }
            }
            k++;
        }
        return result;
    }
}
