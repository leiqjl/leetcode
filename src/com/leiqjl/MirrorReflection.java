package com.leiqjl;

/**
 * 858. Mirror Reflection - Medium
 */
public class MirrorReflection {
    // p*a=q*b
    public int mirrorReflection(int p, int q) {
        int a = q, b = p;
        while (a % 2 == 0 && b % 2 == 0) {
            a /= 2;
            b /= 2;
        }
        if (a % 2 == 0 && b % 2 == 1) {
            return 0;
        }
        if (a % 2 == 1 && b % 2 == 1) {
            return 1;
        }
        if (a % 2 == 1 && b % 2 == 0) {
            return 2;
        }
        return -1;
    }
}
