package com.leiqjl;

/**
 * 762. Prime Number of Set Bits in Binary Representation - Easy
 * Given two integers left and right, return the count of numbers in the inclusive range [left, right] having a prime number of set bits in their binary representation.
 *
 * Recall that the number of set bits an integer has is the number of 1's present when written in binary.
 *
 * - For example, 21 written in binary is 10101, which has 3 set bits.
 */
public class PrimeNumberOfSetBitsInBinaryRepresentation {
    //Constraints:
    //
    //1 <= left <= right <= 10^6
    //0 <= right - left <= 10^4
    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            int bits = Integer.bitCount(i);
            if (bits == 2 || bits == 3 || bits == 5 || bits == 7 || bits == 11 || bits == 13 || bits == 17 || bits == 19) {
                count++;
            }
        }
        return count;
    }
}
