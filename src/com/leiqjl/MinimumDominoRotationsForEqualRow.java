package com.leiqjl;

/**
 * 1007. Minimum Domino Rotations For Equal Row - Medium
 */
public class MinimumDominoRotationsForEqualRow {

    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        int[] a = new int[7], b = new int[7], same = new int[7];
        for (int i = 0; i < n; i++) {
            a[tops[i]]++;
            b[bottoms[i]]++;
            if (tops[i] == bottoms[i]) {
                same[tops[i]]++;
            }
        }
        for (int i = 1; i <= 6; i++) {
            if (a[i] + b[i] - same[i] == n) {
                return n - Math.max(a[i], b[i]);
            }
        }
        return -1;
    }
}
