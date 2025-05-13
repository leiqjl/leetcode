package com.leiqjl;

/**
 * 3335. Total Characters in String After Transformations I - Medium
 */
public class TotalCharactersInStringAfterTransformationsI {

    public int lengthAfterTransformations(String s, int t) {
        int mod = 1000000007;
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        for (int i = 0; i < t; i++) {
            int[] next = new int[26];
            for (int j = 1; j < 26; j++) {
                next[j] = cnt[j - 1];
            }
            //z -> ab
            next[0] = cnt[25];
            next[1] = (next[1] + cnt[25]) % mod;
            cnt = next;
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            res = (res + cnt[i]) % mod;
        }
        return res;
    }

    public static void main(String[] args) {
        TotalCharactersInStringAfterTransformationsI t = new TotalCharactersInStringAfterTransformationsI();
        assert t.lengthAfterTransformations("abcyy", 2) == 7;
        assert t.lengthAfterTransformations("azbk", 1) == 5;
    }
}
