package com.leiqjl;

/**
 * 2566. Maximum Difference by Remapping a Digit - Easy
 */
public class MaximumDifferenceByRemappingADigit {
    public int minMaxDifference(int num) {
        String str1 = String.valueOf(num);
        String str2 = str1;
        int index = 0;
        while (index < str1.length() && str1.charAt(index) == '9') {
            index++;
        }
        if (index < str1.length()) {
            str1 = str1.replace(str1.charAt(index), '9');
        }
        str2 = str2.replace(str2.charAt(0), '0');
        return Integer.parseInt(str1) - Integer.parseInt(str2);
    }
}
