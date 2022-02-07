package com.leiqjl;

/**
 * 125. Valid Palindrome
 *
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters,
 * it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int i = 0, j = s.length()-1;
        while (i <= j) {
            while (i<=j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i<=j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (i <= j) {
                if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }
}
