package com.leiqjl;

/**
 * 28. Find the Index of the First Occurrence in a String - Medium
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class FindTheIndexOfTheFirstOccurrenceInAString {

    //Constraints:
    //
    //1 <= haystack.length, needle.length <= 10^4
    //haystack and needle consist of only lowercase English characters.

    //time O(mn) space O(1)
    public int strStr(String haystack, String needle) {
        int h = haystack.length();
        int n = needle.length();
        for (int i = 0; i <= h - n; i++) {
            for (int j = 0; j < n; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                if (j == n - 1) {
                    return i;
                }
            }
        }
        return -1;
    }

    //Rabin-Karp Algorithm(Single Hash)
    //time O(mn) space O(1)
    //Rabin-Karp Algorithm(Double Hash)
    //time O(n) space O(1)

    public int strStr1(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        int[] lps = lpsArray(needle);
        int i = 0, j = 0;
        while (i <= m - n) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == n) {
                    return i - n;
                }
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = lps[j-1];
                }
            }
        }
        return -1;
    }

    private int[] lpsArray(String str) {
        int[] lps = new int[str.length()];
        int i = 1, prev = 0;
        while (i < str.length()) {
            if (str.charAt(i) == str.charAt(prev)) {
                prev++;
                lps[i] = prev;
                i++;
            } else {
                if (prev == 0) {
                    lps[i] = 0;
                    i++;
                } else {
                    prev = lps[prev - 1];
                }
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        String str = "AAACAAAA";
        int[] lps = new int[str.length()];
        int i = 1, prev = 0;
        while (i < str.length()) {
            if (str.charAt(i) == str.charAt(prev)) {
                prev++;
                lps[i] = prev;
                i++;
            } else {
                if (prev == 0) {
                    lps[i] = 0;
                    i++;
                } else {
                    prev = lps[prev - 1];
                }
            }
        }
        System.out.println(lps.length);
    }
}