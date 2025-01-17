package com.leiqjl;

/**
 * 2683. Neighboring Bitwise XOR - Medium
 * A 0-indexed array derived with length n is derived by computing the bitwise XOR (⊕) of adjacent values in a binary array original of length n.
 * <p>
 * Specifically, for each index i in the range [0, n - 1]:
 * <p>
 * · If i = n - 1, then derived[i] = original[i] ⊕ original[0].
 * · Otherwise, derived[i] = original[i] ⊕ original[i + 1].
 * <p>
 * Given an array derived, your task is to determine whether there exists a valid binary array original that could have formed derived.
 * <p>
 * Return true if such an array exists or false otherwise.
 * <p>
 * A binary array is an array containing only 0's and 1's
 */
public class NeighboringBitwiseXOR {
    // 1 0 1
    // 1 1 0
    // 1 1 0
    // 0 0 0
    //derived[0] = original[0] ⊕ original[1] = 0 ⊕ 1 = 1
    //derived[1] = original[1] ⊕ original[2] = 1 ⊕ 0 = 1
    //derived[2] = original[2] ⊕ original[0] = 0 ⊕ 0 = 0
    public boolean doesValidArrayExist(int[] derived) {
        int xor = 0;
        for (int i = 0; i < derived.length; i++) {
            xor ^= derived[i];
        }
        return xor == 0;
    }

    public static void main(String[] args) {
        NeighboringBitwiseXOR b = new NeighboringBitwiseXOR();
        //[0,1,0]
        assert b.doesValidArrayExist(new int[]{1, 1, 0});
        //[0,1]
        assert b.doesValidArrayExist(new int[]{1, 1});
        assert !b.doesValidArrayExist(new int[]{1, 0});
    }
}
