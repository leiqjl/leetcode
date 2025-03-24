package com.leiqjl;

/**
 * 1839. Longest Substring Of All Vowels in Order - Medium
 */
public class LongestSubstringOfAllVowelsInOrder {
    //'aeiou'
    public int longestBeautifulSubstring(String word) {
        int winStart = 0, winEnd = 0, maxLen = 0, vowelsCount = 0;
        while (winEnd < word.length()) {
            if (word.charAt(winEnd) == 'a') {
                winStart = winEnd;
                winEnd = winEnd + 1;
                vowelsCount = 1;
                while (winEnd < word.length()) {
                    if (word.charAt(winEnd) < word.charAt(winEnd - 1)) {
                        winEnd--;
                        break;
                    }
                    if (word.charAt(winEnd) != word.charAt(winEnd - 1)) {
                        vowelsCount++;
                    }
                    if (vowelsCount == 5) {
                        maxLen = Math.max(maxLen, winEnd - winStart + 1);
                    }
                    winEnd++;
                }

            }
            winEnd++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubstringOfAllVowelsInOrder l = new LongestSubstringOfAllVowelsInOrder();
        assert l.longestBeautifulSubstring("aeiaaioaaaaeiiiiouuuooaauuaeiu") == 13;
        assert l.longestBeautifulSubstring("aeeeiiiioooauuuaeiou") == 5;
        assert l.longestBeautifulSubstring("a") == 0;
    }
}
