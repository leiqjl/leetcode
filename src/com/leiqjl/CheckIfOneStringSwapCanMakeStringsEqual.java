package com.leiqjl;

/**
 * 1790. Check if One String Swap Can Make Strings Equal - Easy
 */
public class CheckIfOneStringSwapCanMakeStringsEqual {
    public boolean areAlmostEqual(String s1, String s2) {

        int count = 0;
        int first = 0, second = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (count > 2) {
                    return false;
                } else if (count == 1) {
                    first = i;
                } else {
                    second = i;
                }
            }
        }

        return (s1.charAt(first) == s2.charAt(second)) && (s1.charAt(second) == s2.charAt(first));
    }
}
