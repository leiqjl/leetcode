package com.leiqjl;

/**
 * 172. Factorial Trailing Zeroes - Medium
 * Given an integer n, return the number of trailing zeroes in n!.
 * <p>
 * Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.
 */
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        if (n == 0) {
            return 0;
        }
        int result = 0;
        while (n > 0) {
            n /= 5;
            result += n;
        }
        return result;
    }

    public static void main(String[] args) {
        FactorialTrailingZeroes f = new FactorialTrailingZeroes();

        assert f.trailingZeroes(3) == 0;
        assert f.trailingZeroes(5) == 1;
        assert f.trailingZeroes(0) == 0;
        assert f.trailingZeroes(30) == 7;
    }
}
