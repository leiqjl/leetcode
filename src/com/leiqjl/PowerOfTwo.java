package com.leiqjl;

/**
 * 231. Power of Two - Easy
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
