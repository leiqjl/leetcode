package com.leiqjl;

/**
 * 1750. Minimum Length of String After Deleting Similar Ends - Medium
 */
public class MinimumLengthOfStringAfterDeletingSimilarEnds {
    // two pointers
    public int minimumLength(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right && s.charAt(left) == s.charAt(right)) {
            char c = s.charAt(left);
            while (left <= right && s.charAt(left) == c) {
                left++;
            }
            while (left < right && s.charAt(right) == c) {
                right--;
            }
        }
        return right - left + 1;
    }
}
