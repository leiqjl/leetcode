package com.leiqjl;

/**
 * 509. Fibonacci Number - Easy
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
 * <p>
 * - F(0) = 0, F(1) = 1
 * - F(n) = F(n - 1) + F(n - 2), for n > 1.
 * <p>
 * Given n, calculate F(n).
 */
public class FibonacciNumber {

    public int fib1(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int a = 0, b = 1;
        while (n > 1) {
            int tmp = a + b;
            a = b;
            b = tmp;
            n--;
        }
        return b;
    }

    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        FibonacciNumber f = new FibonacciNumber();
        assert f.fib(2) == 1;
        assert f.fib(3) == 2;
        assert f.fib(4) == 3;
    }
}
