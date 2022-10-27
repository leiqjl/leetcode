package com.leiqjl;

/**
 * 1662. Check If Two String Arrays are Equivalent - Easy
 */
public class CheckIfTwoStringArraysAreEquivalent {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int idx1 = 0, idx2 = 0, wi1 = 0, wi2 = 0;
        while (idx1 < word1.length && idx2 < word2.length) {
            if (word1[idx1].charAt(wi1) != word2[idx2].charAt(wi2)) {
                return false;
            }
            if (wi1 < word1[idx1].length() - 1) {
                wi1++;
            } else {
                idx1++;
                wi1 = 0;
            }
            if (wi2 < word2[idx2].length() - 1) {
                wi2++;
            } else {
                idx2++;
                wi2 = 0;
            }
        }
        return idx1 == word1.length && idx2 == word2.length;
    }
}
