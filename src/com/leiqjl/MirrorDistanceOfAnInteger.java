package com.leiqjl;

/**
 * 3783. Mirror Distance of an Integer - Easy
 */
public class MirrorDistanceOfAnInteger {
    public int mirrorDistance(int num) {
        int reverse = reverse(num);
        return Math.abs(num - reverse);
    }

    private int reverse(int x) {
        int res = 0;
        while (x > 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res;
    }
}
