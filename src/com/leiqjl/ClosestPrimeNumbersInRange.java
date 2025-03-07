package com.leiqjl;

import java.util.Arrays;

/**
 * 2523. Closest Prime Numbers in Range - Medium
 * <p>
 * Given two positive integers left and right, find the two integers num1 and num2 such that:
 * <p>
 * ·left <= num1 < num2 <= right .
 * ·Both num1 and num2 are prime numbers.
 * ·num2 - num1 is the minimum amongst all other pairs satisfying the above conditions.
 * <p>
 * Return the positive integer array ans = [num1, num2]. If there are multiple pairs satisfying these conditions, return the one with the smallest num1 value. If no such numbers exist, return [-1, -1].
 */
public class ClosestPrimeNumbersInRange {
    //1 <= left <= right <= 10^6
    //Sieve of Eratosthenes
    public int[] closestPrimes(int left, int right) {
        boolean[] isPrime = new boolean[right + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= right; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= right; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int min = Integer.MAX_VALUE, pre = -1;
        int[] result = new int[]{-1, -1};

        for (int cur = left; cur <= right; cur++) {
            if (isPrime[cur]) {
                if (pre != -1 && cur - pre < min) {
                    min = cur - pre;
                    result[0] = pre;
                    result[1] = cur;
                }
                pre = cur;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ClosestPrimeNumbersInRange c = new ClosestPrimeNumbersInRange();
        assert Arrays.toString(c.closestPrimes(10, 19)).equals("[11, 13]");
        assert Arrays.toString(c.closestPrimes(4, 6)).equals("[-1, -1]");
    }
}
