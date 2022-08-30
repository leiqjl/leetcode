package com.leiqjl;

/**
 * 383. Ransom Note - Easy
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for (char m : magazine.toCharArray()) {
            arr[m - 'a']++;
        }
        for (char r : ransomNote.toCharArray()) {
            arr[r - 'a']--;
            if (arr[r - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
