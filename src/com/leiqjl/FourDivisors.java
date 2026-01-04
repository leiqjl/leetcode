package com.leiqjl;

/**
 * 1390. Four Divisors - Medium
 * Given an integer array nums, return the sum of divisors of the integers in that array that have exactly four divisors.
 * If there is no such integer in the array, return 0.
 */
public class FourDivisors {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            int lastDivisor = 0;
            for (int d = 2; d * d <= num; d++) {
                if (num % d == 0) {
                    if (lastDivisor != 0) {
                        lastDivisor = 0;
                        break;
                    }
                    lastDivisor = d;
                }
            }
            if (lastDivisor > 0 && lastDivisor != num / lastDivisor) {
                sum += 1 + num + lastDivisor + num / lastDivisor;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        FourDivisors f = new FourDivisors();
        assert f.sumFourDivisors(new int[]{21, 4, 7}) == 32;
        assert f.sumFourDivisors(new int[]{21, 21}) == 64;
        assert f.sumFourDivisors(new int[]{1, 2, 3, 4, 5}) == 0;
    }
}
