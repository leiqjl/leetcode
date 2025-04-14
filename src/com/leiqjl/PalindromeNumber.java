package com.leiqjl;

/**
 * 9. Palindrome Number - Easy
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int originalNum = x;
        int reverseNum = 0;
        while (x > 0) {
            int digit = x % 10;
            reverseNum = reverseNum * 10 + digit;
            x /= 10;
        }
        return originalNum == reverseNum;
    }

    public static void main(String[] args) {
        PalindromeNumber p = new PalindromeNumber();
        assert p.isPalindrome(121);
        assert !p.isPalindrome(-121);
        assert !p.isPalindrome(10);
    }
}
