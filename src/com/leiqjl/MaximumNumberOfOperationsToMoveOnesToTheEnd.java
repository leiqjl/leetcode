package com.leiqjl;

/**
 * 3228. Maximum Number of Operations to Move Ones to the End - Medium
 */
public class MaximumNumberOfOperationsToMoveOnesToTheEnd {
    public int maxOperations(String s) {
        int max = 0, count = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                count++;
            } else if (i + 1 == n || s.charAt(i + 1) == '1') {
                max += count;
            }
        }
        return max;
    }
}
