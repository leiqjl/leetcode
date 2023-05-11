package com.leiqjl;

/**
 * 1456. Maximum Number of Vowels in a Substring of Given Length - Medium
 */
public class MaximumNumberOfVowelsInASubstringOfGivenLength {
    public int maxVowels(String s, int k) {
        int count = 0;
        for (int i = 0; i < Math.min(s.length(), k); i++) {
            if ("aeiou".indexOf(s.charAt(i)) >= 0) {
                count++;
            }
        }
        int max = count;
        int r = k, l = 0;
        while (r < s.length()) {
            System.out.println(s.charAt(r));
            if ("aeiou".indexOf(s.charAt(r)) >= 0) {
                count++;
            }
            if ("aeiou".indexOf(s.charAt(l)) >= 0) {
                count--;
            }
            r++;
            l++;
            max = Math.max(max, count);
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumNumberOfVowelsInASubstringOfGivenLength m = new MaximumNumberOfVowelsInASubstringOfGivenLength();
        assert m.maxVowels("abciiidef", 3) == 3;
        assert m.maxVowels("aeiou", 2) == 2;
        assert m.maxVowels("leetcode", 3) == 2;
        assert m.maxVowels("tryhard", 4) == 1;
        assert m.maxVowels("ibpbhixfiouhdljnjfflpapptrxgcomvnb", 33) == 7;
    }
}
