package com.leiqjl;

/**
 * 1189. Maximum Number of Balloons - Easy
 * Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
 * <p>
 * You can use each character in text at most once. Return the maximum number of instances that can be formed.
 */
public class MaximumNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
        int[] count = new int[26];
        for (char c : text.toCharArray()) {
            count[c - 'a']++;
        }
        int min = Integer.MAX_VALUE;
        // 'l' and 'o' need to be divided by 2
        for (int i = 0; i < 26; i++) {
            char c = (char) (i + 'a');
            if ("balloon".indexOf(c) == -1) {
                continue;
            }
            if (c == 'l' || c == 'o') {
                min = Math.min(min, count[i] / 2);
            } else {
                min = Math.min(min, count[i]);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        MaximumNumberOfBalloons m = new MaximumNumberOfBalloons();
        assert m.maxNumberOfBalloons("nlaebolko") == 1;
        assert m.maxNumberOfBalloons("loonbalxballpoon") == 2;
        assert m.maxNumberOfBalloons("leetcode") == 0;
    }
}
