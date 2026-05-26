package com.leiqjl;

/**
 * 3120. Count the Number of Special Characters I - Easy
 */
public class CountTheNumberOfSpecialCharactersI {
    public int numberOfSpecialChars(String word) {
        int a = 0, A = 0;
        for (char c : word.toCharArray()) {
            if (Character.isLowerCase(c)) {
                a = a | (1 << (c - 'a'));
            } else {
                A = A | (1 << (c - 'A'));
            }
        }
        return Integer.bitCount(a & A);
    }
}
