package com.leiqjl;

/**
 * 1922. Count Good Numbers - Medium
 */
public class CountGoodNumbers {
    long mod = 1000000007;

    //even 0 2 4 6 8
    //odd  2 3 5 7
    public int countGoodNumbers(long n) {
        long even = (n + 1) / 2;
        long odd = n / 2;
        return (int) (countGoodNumbersHelper(5, even) * countGoodNumbersHelper(4, odd) % mod);
    }

    public long countGoodNumbersHelper(long base, long num) {
        long res = 1;
        while (num > 0) {
            if ((num & 1) == 1) {
                res = (res * base) % mod;
            }
            base = base * base % mod;
            num /= 2;
        }
        return res;
    }


    public static void main(String[] args) {
        CountGoodNumbers c = new CountGoodNumbers();
        assert c.countGoodNumbers(1) == 5;
        assert c.countGoodNumbers(4) == 400;
        assert c.countGoodNumbers(50) == 564908303;
    }
}
