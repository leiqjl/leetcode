package com.leiqjl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 3272. Find the Count of Good Integers - Hard
 * You are given two positive integers n and k.
 * <p>
 * An integer x is called k-palindromic if:
 * <p>
 * ·x is a palindrome.
 * ·x is divisible by k.
 * An integer is called good if its digits can be rearranged to form a k-palindromic integer. For example, for k = 2, 2020 can be rearranged to form the k-palindromic integer 2002, whereas 1010 cannot be rearranged to form a k-palindromic integer.
 * <p>
 * Return the count of good integers containing n digits.
 * <p>
 * Note that any integer must not have leading zeros, neither before nor after rearrangement. For example, 1010 cannot be rearranged to form 101.
 */
public class FindTheCountOfGoodIntegers {
    //Constraints:
    //
    //1 <= n <= 10
    //1 <= k <= 9

    //n = 6
    //left 100-999
    //left+right
    //n!/(n1!*n2*...*nk!)
    public long countGoodIntegers(int n, int k) {
        Set<String> set = new HashSet<>();
        int leftLen = (n + 1) / 2;
        int base = (int) Math.pow(10, leftLen - 1);
        int skip = n & 1;
        for (int i = base; i < base * 10; i++) {
            String leftStr = String.valueOf(i);
            String rightStr = new StringBuilder(leftStr).reverse().substring(skip);
            String str = leftStr + rightStr;
            long num = Long.parseLong(str);
            if (num % k == 0) {
                char[] charArray = str.toCharArray();
                Arrays.sort(charArray);
                set.add(new String(charArray));
            }
        }
        long[] f = new long[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            f[i] = f[i - 1] * i;
        }
        long ans = 0;
        for (String s : set) {
            int[] digits = new int[10];
            for (char c : s.toCharArray()) {
                digits[c - '0']++;
            }
            long count = (n - digits[0]) * f[n - 1];
            for (int c : digits) {
                count /= f[c];
            }
            ans += count;
        }
        return ans;
    }

    public static void main(String[] args) {
        FindTheCountOfGoodIntegers a = new FindTheCountOfGoodIntegers();
        assert a.countGoodIntegers(3, 5) == 27;
        assert a.countGoodIntegers(1, 4) == 2;
        assert a.countGoodIntegers(5, 6) == 2468;
    }
}
