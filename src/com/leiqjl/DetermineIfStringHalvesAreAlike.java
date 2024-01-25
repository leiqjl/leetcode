package com.leiqjl;

import java.util.Set;

/**
 * 1704. Determine if String Halves Are Alike - Easy
 */
public class DetermineIfStringHalvesAreAlike {
    public boolean halvesAreAlike(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int count = 0;
        for (int i = 0, j = s.length() - 1; i < s.length() / 2; i++, j--) {
            if (vowels.contains(s.charAt(i))) count++;
            if (vowels.contains(s.charAt(j))) count--;
        }
        return count == 0;
    }
}
