package com.leiqjl;

/**
 * 1625. Lexicographically Smallest String After Applying Operations - Medium
 */
public class LexicographicallySmallestStringAfterApplyingOperations {
    public String findLexSmallestString(String s, int a, int b) {
        int n = s.length();
        String ans = s;
        s = s + s;
        int gcd = gcd(n, b);
        for (int i = 0; i < n; i += gcd) {
            char[] charArray = s.substring(i, i + n).toCharArray();
            add(charArray, n, a, 0);
            if ((b & 1) == 1) {
                add(charArray, n, a, 1);
            }
            String newStr = new String(charArray);
            if (newStr.compareTo(ans) < 0) {
                ans = newStr;
            }
        }
        return ans;
    }

    private void add(char[] chars, int n, int a, int begin) {
        int min = 10;
        int count = 0;
        for (int i = 0; i < 10; i++) {
            int added = ((chars[begin] - '0') + i * a) % 10;
            if (added < min) {
                min = added;
                count = i;
            }
        }
        for (int i = begin; i < n; i += 2) {
            chars[i] = (char) ('0' + (((chars[i] - '0') + count * a) % 10));
        }
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
