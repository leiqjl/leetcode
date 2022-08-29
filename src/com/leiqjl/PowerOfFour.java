package com.leiqjl;

/**
 * 342. Power of Four - Easy
 */
public class PowerOfFour {
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
    }

    public static void main(String[] args) {
        PowerOfFour p = new PowerOfFour();
        System.out.println(p.isPowerOfFour(16));
    }
}
