package com.leiqjl;

/**
 * 1332. Remove Palindromic Subsequences - Easy
 */
public class RemovePalindromicSubsequences {

    public int removePalindromeSub(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        return isPalindrome(s) ? 1 : 2;
    }

    private boolean isPalindrome(String s) {
        int begin = 0, end = s.length() - 1;
        while (begin < end) {
            if (s.charAt(begin) != s.charAt(end)) {
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }

}
