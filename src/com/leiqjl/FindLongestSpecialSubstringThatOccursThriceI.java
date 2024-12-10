package com.leiqjl;

import java.util.HashMap;
import java.util.Map;

/**
 * 2981. Find Longest Special Substring That Occurs Thrice I - Medium
 */
public class FindLongestSpecialSubstringThatOccursThriceI {
    public int maximumLength(String s) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int l = 0, r = l;
        int maxLen = -1;
        while (r < s.length()) {
            while (r < s.length() && s.charAt(l) == s.charAt(r)) {
                r++;
            }
            for (int i = r - 1; i >= l; i--) {
                int len = i - l + 1;
                int key = (s.charAt(l) - 'a') * 100 + len;
                freqMap.put(key, freqMap.getOrDefault(key, 0) + (r - l - len + 1));
                if (freqMap.get(key) >= 3) {
                    maxLen = Math.max(maxLen, len);
                }
            }
            l = r;
        }
        return maxLen;
    }
}
