package com.leiqjl;

/**
 * 1663. Smallest String With A Given Numeric Value - Medium
 * The numeric value of a lowercase character is defined as its position (1-indexed) in the alphabet, so the numeric value of a is 1, the numeric value of b is 2, the numeric value of c is 3, and so on.
 *
 * The numeric value of a string consisting of lowercase characters is defined as the sum of its characters' numeric values.
 * For example, the numeric value of the string "abe" is equal to 1 + 2 + 5 = 8.
 *
 * You are given two integers n and k. Return the lexicographically smallest string with length equal to n and numeric value equal to k.
 *
 * Note that a string x is lexicographically smaller than string y if x comes before y in dictionary order, that is, either x is a prefix of y, or if i is the first position such that x[i] != y[i], then x[i] comes before y[i] in alphabetic order.
 */
public class SmallestStringWithAGivenNumericValue {
    /**
     * @param n    1 <= n <= 105
     * @param k    n <= k <= 26 * n
     * @return
     */
    public String getSmallestString(int n, int k) {
        char[] chars = new char[n];
        for (int i = 0; i < n; i++) {
            chars[i] = 'a';
        }
        k = k - n;
        for (int i = n-1; i >= 0; i--) {
            if (k == 0) {
                break;
            } else if (k <= 25) {
                chars[i] += k;
                break;
            } else {
                chars[i] += 25;
                k -= 25;
            }
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        SmallestStringWithAGivenNumericValue s = new SmallestStringWithAGivenNumericValue();
        //Input: n = 3, k = 27
        //Output: "aay"
        assert "aay".equals(s.getSmallestString(3, 27));
        //Input: n = 5, k = 73
        //Output: "aaszz"
        assert "aaszz".equals(s.getSmallestString(5, 73));
    }
}
