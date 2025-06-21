package com.leiqjl;

/**
 * 3085. Minimum Deletions to Make String K-Special - Medium
 */
public class MinimumDeletionsToMakeStringKSpecial {
    public int minimumDeletions(String word, int k) {
        int[] freqArr = new int[26];
        for (char c : word.toCharArray()) {
            freqArr[c - 'a']++;
        }
        int ans = Integer.MAX_VALUE;
        for (int freq : freqArr) {
            if (freq == 0) {
                continue;
            }
            int deleteNum = 0;
            for (int f : freqArr) {
                if (f == 0) {
                    continue;
                }
                if (f < freq) {
                    deleteNum += f;
                } else if (f - k > freq) {
                    deleteNum += (f - k - freq);
                }
            }
            ans = Math.min(ans, deleteNum);
        }
        return ans;
    }

    public static void main(String[] args) {
        MinimumDeletionsToMakeStringKSpecial m = new MinimumDeletionsToMakeStringKSpecial();
        assert m.minimumDeletions("aabcaba", 0) == 3;
        assert m.minimumDeletions("dabdcbdcdcd", 2) == 2;
        assert m.minimumDeletions("aaabaaa", 2) == 1;
    }
}
