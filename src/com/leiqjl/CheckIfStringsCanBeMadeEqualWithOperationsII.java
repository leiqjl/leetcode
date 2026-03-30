package com.leiqjl;

/**
 * 2840. Check if Strings Can be Made Equal With Operations II - medium
 */
public class CheckIfStringsCanBeMadeEqualWithOperationsII {
    public boolean checkStrings(String s1, String s2) {
        int[] freq = new int[26];
        for (int i = 0; i < s1.length(); i += 2) {
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
        }
        if (!check(freq)) {
            return false;
        }
        for (int i = 1; i < s1.length(); i += 2) {
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
        }
        return check(freq);
    }

    private boolean check(int[] freq) {
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
