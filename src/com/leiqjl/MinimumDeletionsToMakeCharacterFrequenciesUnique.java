package com.leiqjl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 1647. Minimum Deletions to Make Character Frequencies Unique - Medium
 * <p>
 * A string s is called good if there are no two different characters in s that have the same frequency.
 * <p>
 * Given a string s, return the minimum number of characters you need to delete to make s good.
 * <p>
 * The frequency of a character in a string is the number of times it appears in the string.
 * For example, in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.
 */
public class MinimumDeletionsToMakeCharacterFrequenciesUnique {
    //1 <= s.length <= 10^5
    //s contains only lowercase English letters.
    public int minDeletions(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        Arrays.sort(cnt);
        int deleteCount = 0;
        int max = s.length();
        for (int i = 25; i >= 0; i--) {
            if (cnt[i] == 0) {
                break;
            }
            if (cnt[i] > max) {
                deleteCount += (cnt[i] - max);
                cnt[i] = max;
            }
            max = Math.max(cnt[i] - 1, 0);
        }
        return deleteCount;
    }

    public int minDeletions1(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        Set<Integer> set = new HashSet<>();
        int deleteCount = 0;
        for (int i = 0; i < 26; i++) {
            while (cnt[i] > 0) {
                if (!set.contains(cnt[i])) {
                    set.add(cnt[i]);
                    break;
                }
                cnt[i]--;
                deleteCount++;
            }
        }
        return deleteCount;
    }


    public static void main(String[] args) {
        MinimumDeletionsToMakeCharacterFrequenciesUnique m = new MinimumDeletionsToMakeCharacterFrequenciesUnique();
        //Input: s = "aab"
        //Output: 0
        //Explanation: s is already good.
        String s = "aab";
        assert m.minDeletions(s) == 0;
        //Input: s = "aaabbbcc"
        //Output: 2
        //Explanation: You can delete two 'b's resulting in the good string "aaabcc".
        //Another way it to delete one 'b' and one 'c' resulting in the good string "aaabbc".
        s = "aaabbbcc";
        assert m.minDeletions(s) == 2;
        //Input: s = "ceabaacb"
        //Output: 2
        //Explanation: You can delete both 'c's resulting in the good string "eabaab".
        //Note that we only care about characters that are still in the string at the end (i.e. frequency of 0 is ignored).
        s = "ceabaacb";
        assert m.minDeletions(s) == 2;

        s = "bbcebab";
        assert m.minDeletions(s) == 2;
    }
}
