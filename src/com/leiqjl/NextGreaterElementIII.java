package com.leiqjl;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 556. Next Greater Element III - Medium
 * <p>
 * Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer n and is greater in value than n.
 * If no such positive integer exists, return -1.
 * <p>
 * Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does not fit in 32-bit integer, return -1.
 */
public class NextGreaterElementIII {

    //1 <= n <= 2^31 - 1
    public int nextGreaterElement(int n) {
        char[] chars = Integer.toString(n).toCharArray();
        int i = chars.length - 1;
        while (i > 0) {
            if (chars[i] > chars[i - 1]) {
                break;
            }
            i--;
        }
        if (i == 0) {
            return -1;
        }
        int idx = i;
        for (int j = i + 1; j < chars.length; j++) {
            if (chars[j] > chars[i - 1] && chars[j] <= chars[idx]) {
                idx = j;
            }
        }
        char tmp = chars[idx];
        chars[idx] = chars[i - 1];
        chars[i - 1] = tmp;

        reverse(chars, i, chars.length - 1);
        long val = Long.parseLong(new String(chars));
        return (val <= Integer.MAX_VALUE) ? (int) val : -1;
    }

    private void reverse(char[] chars, int l, int r) {
        while (l < r) {
            char tmp = chars[l];
            chars[l] = chars[r];
            chars[r] = tmp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        NextGreaterElementIII n = new NextGreaterElementIII();
        assert n.nextGreaterElement(12) == 21;
        assert n.nextGreaterElement(21) == -1;
        //230421
        assert n.nextGreaterElement(230241) == 230412;
        assert n.nextGreaterElement(23024321) == 23031224;
    }
}
