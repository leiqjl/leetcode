package com.leiqjl;

/**
 * 799. Champagne Tower - Medium
 */
public class ChampagneTower {

    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] res = new double[101][101];
        res[0][0] = poured;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j <= i; j++) {
                if (res[i][j] > 1) {
                    res[i + 1][j + 1] += (res[i][j] - 1) / 2;
                    res[i + 1][j] += (res[i][j] - 1) / 2;
                    res[i][j] = 1;
                }
            }
        }
        return res[query_row][query_glass];
    }

    public double champagneTower1(int poured, int query_row, int query_glass) {
        double[] res = new double[query_row + 2];
        res[0] = poured;
        for (int i = 1; i <= query_row; i++) {
            for (int j = i; j >= 0; j--) {
                double overflow = Math.max(0.0, (res[j] - 1) / 2);
                res[j + 1] += overflow;
                res[j] = overflow;
            }
        }
        return Math.min(res[query_glass], 1.0);
    }

}
