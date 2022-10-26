package com.leiqjl;

import java.util.ArrayList;
import java.util.List;

/**
 * 1239. Maximum Length of a Concatenated String with Unique Characters - Medium
 */
public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters {

    public int maxLength(List<String> arr) {
        int maxLen = 0;
        List<Integer> dp = new ArrayList<>();
        dp.add(0);
        for (String s : arr) {
            int dup = 0, cur = 0;
            for (char c : s.toCharArray()) {
                dup |= (1 << (c - 'a')) & cur;
                cur |= (1 << (c - 'a'));
            }
            if (dup > 0) {
                continue;
            }
            for (int i = dp.size() - 1; i >= 0; i--) {
                int tmp = dp.get(i);
                if ((tmp & cur) > 0) {
                    continue;
                }
                tmp = tmp | cur;
                dp.add(tmp);
                maxLen = Math.max(maxLen, Integer.bitCount(tmp));
            }
        }
        return maxLen;
    }

}
