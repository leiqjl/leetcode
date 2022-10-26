package com.leiqjl;

/**
 * 1680. Concatenation of Consecutive Binary Numbers - Medium
 * Given an integer n, return the decimal value of the binary string formed by concatenating the binary representations of 1 to n in order, modulo 10^9 + 7.
 */
public class ConcatenationOfConsecutiveBinaryNumbers {
    //1 <= n <= 10^5
    public int concatenatedBinary(int n) {
        int mod = 1000000007;
        long res = 1;
        int bitCount = 1;
        for (int i = 2; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                bitCount++;
            }
            res = ((res << bitCount) + i) % mod;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        ConcatenationOfConsecutiveBinaryNumbers c = new ConcatenationOfConsecutiveBinaryNumbers();
        //Input: n = 1
        //Output: 1
        assert c.concatenatedBinary(1) == 1;
        //Input: n = 3
        //Output: 27
        // 11011
        assert c.concatenatedBinary(3) == 27;
        //Input: n = 12
        //Output: 505379714
        assert c.concatenatedBinary(12) == 505379714;
        //Input: n = 42
        //Output: 727837408
        assert c.concatenatedBinary(42) == 727837408;
    }
}
