package com.leiqjl;

/**
 * 3754. Concatenate Non-Zero Digits and Multiply by Sum I - Easy
 */
public class ConcatenateNonZeroDigitsAndMultiplyBySumI {
    public long sumAndMultiply(int n) {
        long x = 0, sum = 0, base = 1;
        while (n > 0) {
            int d = n % 10;
            n /= 10;
            if (d == 0) {
                continue;
            }
            x += d * base;
            sum += d;
            base *= 10;
        }
        return x * sum;
    }
}
