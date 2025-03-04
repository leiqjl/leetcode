package com.leiqjl;

/**
 * 326. Power of Three - Easy
 */
public class PowerOfThree {

    //Follow up: Could you solve it without loops/recursion?
    //-2^31 <= n <= 2^31 - 1
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        return (Math.pow(3, 19) % n) == 0;
    }

    public static void main(String[] args) {
        PowerOfThree p = new PowerOfThree();
        assert p.isPowerOfThree(27);
        assert !p.isPowerOfThree(0);
        assert p.isPowerOfThree(9);
    }
}
