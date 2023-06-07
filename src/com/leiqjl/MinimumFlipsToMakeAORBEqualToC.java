package com.leiqjl;

/**
 * 1318. Minimum Flips to Make a OR b Equal to c - Medium
 * Given 3 positives numbers a, b and c. Return the minimum flips required in some bits of a and b to make ( a OR b == c ). (bitwise OR operation).
 * Flip operation consists of change any single bit 1 to 0 or change the bit 0 to 1 in their binary representation.
 */
public class MinimumFlipsToMakeAORBEqualToC {
    //Constraints:
    //
    //1 <= a <= 10^9
    //1 <= b <= 10^9
    //1 <= c <= 10^9
    public int minFlips(int a, int b, int c) {
        int count = 0;
        while (a != 0 | b != 0 | c != 0) {
            if ((c & 1) == 0) {
                count = count + (a & 1) + (b & 1);
            } else if ((a & 1) == 0 && (b & 1) == 0) {
                count++;
            }
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        return count;
    }

    public int minFlips1(int a, int b, int c) {
        return Integer.bitCount((a | b) ^ c) + Integer.bitCount((a & b) & ((a | b) ^ c));
    }

    public static void main(String[] args) {
        MinimumFlipsToMakeAORBEqualToC m = new MinimumFlipsToMakeAORBEqualToC();
        assert m.minFlips(2, 6, 5) == 3;
        assert m.minFlips(4, 2, 7) == 1;
        assert m.minFlips(1, 2, 3) == 0;
        assert m.minFlips(258343848, 90957776, 291428165) == 18;
        assert m.minFlips(8, 3, 5) == 3;
    }
}
