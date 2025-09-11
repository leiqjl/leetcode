package com.leiqjl;

/**
 * 2785. Sort Vowels in a String - Medium
 */
public class SortVowelsInAString {
    public String sortVowels(String s) {
        int[] count = new int['u' - 'A' + 1];
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (isVowel(c)) {
                count[c - 'A']++;
            }
        }
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isVowel(c)) {
                while (count[index] == 0) {
                    index++;
                }
                count[index]--;
                charArray[i] = (char) ('A' + index);
            }
        }
        return new String(charArray);
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
