package com.leiqjl;

/**
 * 3461. Check If Digits Are Equal in String After Operations I - Easy
 * You are given a string s consisting of digits. Perform the following operation repeatedly until the string has exactly two digits:
 * <p>
 * ·For each pair of consecutive digits in s, starting from the first digit, calculate a new digit as the sum of the two digits modulo 10.
 * ·Replace s with the sequence of newly calculated digits, maintaining the order in which they are computed.
 * Return true if the final two digits in s are the same; otherwise, return false.
 */
public class CheckIfDigitsAreEqualInStringAfterOperationsI {
    public boolean hasSameDigits(String s) {
        int n = s.length();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.charAt(i) - '0';
        }
        while (n > 2) {
            for (int i = 0; i < n - 1; i++) {
                arr[i] = (arr[i] + arr[i + 1]) % 10;
            }
            n--;
        }
        return arr[0] == arr[1];
    }
}
