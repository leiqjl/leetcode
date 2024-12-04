package com.leiqjl;

/**
 * 2825. Make String a Subsequence Using Cyclic Increments - Medium
 * <p>
 * You are given two 0-indexed strings str1 and str2.
 * <p>
 * In an operation, you select a set of indices in str1, and for each index i in the set, increment str1[i] to the next character cyclically.
 * That is 'a' becomes 'b', 'b' becomes 'c', and so on, and 'z' becomes 'a'.
 * <p>
 * Return true if it is possible to make str2 a subsequence of str1 by performing the operation at most once, and false otherwise.
 * <p>
 * Note: A subsequence of a string is a new string that is formed from the original string by deleting some (possibly none) of the characters without disturbing the relative positions of the remaining characters.
 */
public class MakeStringASubsequenceUsingCyclicIncrements {

    public boolean canMakeSubsequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(j);
            if (c1 == c2 || c2 - c1 == 1 || c1 - c2 == 25) {
                j++;
            }
            i++;
            if (j == m) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MakeStringASubsequenceUsingCyclicIncrements m = new MakeStringASubsequenceUsingCyclicIncrements();
        //Input: str1 = "abc", str2 = "ad"
        //Output: true
        assert m.canMakeSubsequence("abc", "ad");
        //Input: str1 = "zc", str2 = "ad"
        //Output: true
        assert m.canMakeSubsequence("zc", "ad");
        //Input: str1 = "ab", str2 = "d"
        //Output: false
        assert !m.canMakeSubsequence("ab", "d");
    }
}
