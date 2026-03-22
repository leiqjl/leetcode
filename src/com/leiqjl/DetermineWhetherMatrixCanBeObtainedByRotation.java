package com.leiqjl;

import java.util.Arrays;

/**
 * 1886. Determine Whether Matrix Can Be Obtained By Rotation - Easy
 */
public class DetermineWhetherMatrixCanBeObtainedByRotation {

    /**
     * 0   i,j   i,j
     * 90  i,j   j,n-1-i
     * 180 i,j   n-1-i,n-1-j
     * 270 i,j   n-1-j,i
     *
     * @param mat
     * @param target
     * @return
     */
    public boolean findRotation(int[][] mat, int[][] target) {
        boolean[] flags = new boolean[4];
        Arrays.fill(flags, true);
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != target[i][j]) {
                    flags[0] = false;
                }
                if (mat[i][j] != target[j][n - 1 - i]) {
                    flags[1] = false;
                }
                if (mat[i][j] != target[n - 1 - i][n - 1 - j]) {
                    flags[2] = false;
                }
                if (mat[i][j] != target[n - 1 - j][i]) {
                    flags[3] = false;
                }
            }
        }
        return flags[0] || flags[1] || flags[2] || flags[3];
    }
}
