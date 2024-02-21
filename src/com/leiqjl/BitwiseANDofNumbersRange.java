package com.leiqjl;

/**
 * 201. Bitwise AND of Numbers Range - Medium
 */
public class BitwiseANDofNumbersRange {
    public int rangeBitwiseAnd(int left, int right) {
        while (right > left) {
            right = right & right - 1;
        }
        return left & right;
    }
}
