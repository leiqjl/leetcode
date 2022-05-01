package com.leiqjl;

/**
 * 844. Backspace String Compare - Easy
 * <p>
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
 * <p>
 * Note that after backspacing an empty text, the text will continue empty.
 */
public class BackspaceStringCompare {

    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        int sCount = 0, tCount = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    sCount++;
                } else if (sCount == 0) {
                    break;
                } else {
                    sCount--;
                }
                i--;
            }
            char ic = i < 0 ? '!' : s.charAt(i);
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    tCount++;
                } else if (tCount == 0) {
                    break;
                } else {
                    tCount--;
                }
                j--;
            }
            char jc = j < 0 ? '!' : t.charAt(j);
            if (ic != jc) {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        BackspaceStringCompare b = new BackspaceStringCompare();
        //"nzp#o#g"
        //"b#nzp#o#g"
        String s = "nzp#o#g";
        String t = "b#nzp#o#g";
        assert b.backspaceCompare(s, t);
    }
}
