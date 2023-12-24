package com.leiqjl;

/**
 * 1582. Special Positions in a Binary Matrix - Easy
 */
public class SpecialPositionsInABinaryMatrix {
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] rows = new int[m];
        int[] cols = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rows[i] += mat[i][j];
                cols[j] += mat[i][j];
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            if (rows[i] != 1) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && cols[j] == 1) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SpecialPositionsInABinaryMatrix s = new SpecialPositionsInABinaryMatrix();
        int[][] mat = new int[][]{{1, 0, 0}, {0, 0, 1}, {1, 0, 0}};
        assert s.numSpecial(mat) == 1;
        mat = new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        assert s.numSpecial(mat) == 3;
    }
}
