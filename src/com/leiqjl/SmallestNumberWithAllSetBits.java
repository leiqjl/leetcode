package com.leiqjl;

/**
 * 3370. Smallest Number With All Set Bits - Easy
 * You are given a positive number n.
 * <p>
 * Return the smallest number x greater than or equal to n, such that the binary representation of x contains only set bits
 */
public class SmallestNumberWithAllSetBits {
    public int smallestNumber(int n) {
        int ans = 1;
        while (n > 1) {
            n = n >> 1;
            ans = (ans << 1) + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        SmallestNumberWithAllSetBits s = new SmallestNumberWithAllSetBits();
        assert s.smallestNumber(1) == 1;
        assert s.smallestNumber(5) == 7;
        assert s.smallestNumber(10) == 15;
        assert s.smallestNumber(3) == 3;
    }
}
