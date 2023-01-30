package com.leiqjl;

/**
 * 1137. N-th Tribonacci Number - Easy
 */
public class N_thTribonacciNumber {
    public int tribonacci(int n) {
        if (n <= 1) {
            return 1;
        }
        int a = 0, b = 1, c = 1;
        while (n > 2) {
            int tmp = a + b + c;
            a = b;
            b = c;
            c = tmp;
            n--;
        }
        return c;
    }
}
