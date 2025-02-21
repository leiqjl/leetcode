package com.leiqjl;

import java.util.Arrays;
import java.util.Objects;

/**
 * 1415. The k-th Lexicographical String of All Happy Strings of Length n - Medium
 */
public class TheK_thLexicographicalStringOfAllHappyStringsOfLengthN {

    public String getHappyString(int n, int k) {
        if (k > 3 * (1 << (n - 1))) {
            return "";
        }
        char[] chars = new char[n];
        Arrays.fill(chars, 'a');
        int a = 1;
        int b = a + (1 << (n - 1));
        int c = b + (1 << (n - 1));
        if (k < b) {
            chars[0] = 'a';
            k -= a;
        } else if (k < c) {
            chars[0] = 'b';
            k -= b;
        } else {
            chars[0] = 'c';
            k -= c;
        }
        // ab ba ca
        int[] smallArr = new int[]{1, 0, 0};
        // ac bc cb
        int[] largeArr = new int[]{2, 2, 1};
        for (int i = 1; i < n; i++) {
            int mid = 1 << (n - 1 - i);
            if (k < mid) {
                chars[i] = (char) (smallArr[chars[i - 1] - 'a'] + 'a');
            } else {
                k -= mid;
                chars[i] = (char) (largeArr[chars[i - 1] - 'a'] + 'a');
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        TheK_thLexicographicalStringOfAllHappyStringsOfLengthN s = new TheK_thLexicographicalStringOfAllHappyStringsOfLengthN();
        assert Objects.equals(s.getHappyString(1, 3), "c");
        assert Objects.equals(s.getHappyString(1, 4), "");
        assert Objects.equals(s.getHappyString(3, 9), "cab");
    }
}
