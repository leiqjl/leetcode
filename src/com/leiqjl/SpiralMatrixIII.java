package com.leiqjl;

/**
 * 885. Spiral Matrix III - Medium
 */
public class SpiralMatrixIII {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int k = 0, total = rows * cols;
        int[][] res = new int[total][2];
        res[k++] = new int[]{rStart, cStart};
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};// right,down,left,up
        int len = 0, d = 0;
        while (k < total) {
            if (d == 0 || d == 2) {
                len++;
            }
            for (int i = 0; i < len; i++) {
                rStart += direction[d][0];
                cStart += direction[d][1];
                if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                    res[k++] = new int[]{rStart, cStart};
                }
            }
            d = (d + 1) % 4;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
