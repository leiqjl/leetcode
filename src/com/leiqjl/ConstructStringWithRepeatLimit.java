package com.leiqjl;

/**
 * 2182. Construct String With Repeat Limit - Medium
 * You are given a string s and an integer repeatLimit. Construct a new string repeatLimitedString using the characters of s such that no letter appears more than repeatLimit times in a row. You do not have to use all characters from s.
 * <p>
 * Return the lexicographically largest repeatLimitedString possible.
 * <p>
 * A string a is lexicographically larger than a string b if in the first position where a and b differ, string a has a letter that appears later in the alphabet than the corresponding letter in b. If the first min(a.length, b.length) characters do not differ, then the longer string is the lexicographically larger one.You are given a string s and an integer repeatLimit. Construct a new string repeatLimitedString using the characters of s such that no letter appears more than repeatLimit times in a row. You do not have to use all characters from s.
 */
public class ConstructStringWithRepeatLimit {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        int idx = 25;
        while (true) {
            while (idx >= 0 && cnt[idx] == 0) {
                idx--;
            }
            if (idx < 0) {
                break;
            }
            int count = Math.min(cnt[idx], repeatLimit);
            cnt[idx] -= count;
            for (int i = 0; i < count; i++) {
                sb.append((char) ('a' + idx));
            }
            //next large
            if (cnt[idx] > 0) {
                int i;
                for (i = idx - 1; i >= 0; i--) {
                    if (cnt[i] > 0) {
                        sb.append((char) ('a' + i));
                        cnt[i]--;
                        break;
                    }
                }
                if (i < 0) {
                    return sb.toString();
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ConstructStringWithRepeatLimit c = new ConstructStringWithRepeatLimit();
        assert c.repeatLimitedString("cczazcc", 3).equals("zzcccac");
        assert c.repeatLimitedString("aababab", 2).equals("bbabaa");
        assert c.repeatLimitedString("bplpcfifosybmjxphbxdltxtfrjspgixoxzbpwrtkopepjxfooazjyosengdlvyfchqhqxznnhuuxhtbrojyhxwlsrklsryvmufoibgfyxgjw", 1).equals("zyzyzyxyxyxyxwxwxwxvxvxuxututststsrsrsrqrqrpopopopopopopononmnmlklkljljljijijijhghghghghfhfefefdfdfcfcbab");
    }
}
