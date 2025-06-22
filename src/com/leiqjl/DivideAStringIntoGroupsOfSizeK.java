package com.leiqjl;

import java.util.Arrays;

/**
 * 2138. Divide a String Into Groups of Size k - Easy
 */
public class DivideAStringIntoGroupsOfSizeK {
    public String[] divideString(String s, int k, char fill) {
        int size = s.length() / k + (s.length() % k == 0 ? 0 : 1);
        String[] strArr = new String[size];
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (sb.length() == k) {
                strArr[index++] = sb.toString();
                sb = new StringBuilder();
            }
        }
        if (s.length() % k != 0) {
            while (sb.length() != k) {
                sb.append(fill);
            }
            strArr[index] = sb.toString();
        }
        return strArr;
    }

    public static void main(String[] args) {
        DivideAStringIntoGroupsOfSizeK d = new DivideAStringIntoGroupsOfSizeK();
        System.out.println(Arrays.toString(d.divideString("abcdefghi", 3, 'x')));
        System.out.println(Arrays.toString(d.divideString("abcdefghij", 3, 'x')));
    }
}
