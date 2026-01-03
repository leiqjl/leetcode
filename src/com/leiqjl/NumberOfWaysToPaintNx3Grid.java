package com.leiqjl;

/**
 * 1411. Number of Ways to Paint N × 3 Grid - Hard
 */
public class NumberOfWaysToPaintNx3Grid {
    //3-color comb
    //2 * 3-color comb  and  2 * 2-color comb
    //2-color comb
    //2 * 3-color comb and 3 2-color comb
    public int numOfWays(int n) {
        int mod = 1_000_000_007;
        long color3 = 6, color2 = 6;
        for (int i = 1; i < n; i++) {
            long temp = color3;
            color3 = (2 * color3 + 2 * color2) % mod;
            color2 = (2 * temp + 3 * color2) % mod;
        }
        return (int) ((color3 + color2) % mod);
    }
}
