package com.leiqjl;

/**
 * 1653. Minimum Deletions to Make String Balanced - Medium
 */
public class MinimumDeletionsToMakeStringBalanced {
    public int minimumDeletions(String s) {
        int minDeletions = 0;
        int bCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'b') {
                bCount++;
            } else {
                minDeletions = Math.min(minDeletions + 1, bCount);
            }
        }
        return minDeletions;
    }
}
