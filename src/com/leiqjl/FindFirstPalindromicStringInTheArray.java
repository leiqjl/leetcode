package com.leiqjl;

/**
 * 2108. Find First Palindromic String in the Array
 *
 * Given an array of strings words, return the first palindromic string in the array.
 * If there is no such string, return an empty string "".
 *
 * A string is palindromic if it reads the same forward and backward.
 *
 */
public class FindFirstPalindromicStringInTheArray {

    //1 <= words.length <= 100
    //1 <= words[i].length <= 100
    //words[i] consists only of lowercase English letters.
    public String firstPalindrome(String[] words) {
        for (String w : words) {
            if (isPalindrome(w, 0, w.length()-1)) {
                return w;
            }
        }
        return "";
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left <= right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
