package com.leiqjl;

/**
 * 29. Divide Two Integers - Medium
 */
public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int dividendAbs = Math.abs(dividend), divisorAbs = Math.abs(divisor);
        int res = 0;
        while (dividendAbs - divisorAbs >= 0) {
            int n = 1, tmp = divisorAbs;
            while (dividendAbs - (tmp << 1) >= 0) {
                tmp <<= 1;
                n <<= 1;
            }
            dividendAbs -= tmp;
            res += n;
        }
        if ((dividend > 0) ^ (divisor > 0)) {
            return -res;
        }
        return res;
    }
}
