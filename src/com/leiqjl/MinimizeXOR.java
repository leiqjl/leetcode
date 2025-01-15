package com.leiqjl;

/**
 * 2429. Minimize XOR - Medium
 * Given two positive integers num1 and num2, find the positive integer x such that:
 *
 * · x has the same number of set bits as num2, and
 * · The value x XOR num1 is minimal.
 * Note that XOR is the bitwise XOR operation.
 *
 * Return the integer x. The test cases are generated such that x is uniquely determined.
 *
 * The number of set bits of an integer is the number of 1's in its binary representation.
 */
public class MinimizeXOR {
    //Constraints:
    //
    //1 <= num1, num2 <= 10^9
    public int minimizeXor(int num1, int num2) {
        int cnt1 = Integer.bitCount(num1);
        int cnt2 = Integer.bitCount(num2);
        if (cnt1 == cnt2) {
            return num1;
        }
        int res = num1;
        if (cnt1 > cnt2) {
            for (int i = 0; i < 32; i++) {
                int mask = 1 << i;
                if ((res & mask) != 0) {
                    res ^= mask;
                    cnt1--;
                }
                if (cnt1 == cnt2) {
                    break;
                }
            }
        } else {
            for (int i = 0; i < 32; i++) {
                int mask = 1 << i;
                if ((res & mask) == 0) {
                    res ^= mask;
                    cnt1++;
                }
                if (cnt1 == cnt2) {
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MinimizeXOR m = new MinimizeXOR();
        assert m.minimizeXor(3, 5) == 3;
        assert m.minimizeXor(1, 12) == 3;
        assert m.minimizeXor(79, 74) == 76;
    }
}
