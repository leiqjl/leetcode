package com.leiqjl;

/**
 * Given a string s, find the longest palindromic substring in s.
 * You may assume that the maximum length of s is 1000.
 */
public class LongestPalindromicSubstring {
    private int max = 0;
    private String result = null;

    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        max = 1;
        result = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            checkPalindrome(s, i, i);
            checkPalindrome(s, i, i + 1);
        }
        return result;
    }

    private void checkPalindrome(String s, int i, int j) {
        while (i >= 0 && j <= s.length() - 1) {
            if (s.charAt(i) == s.charAt(j)) {
                if ((j - i + 1) > max) {
                    max = j - i + 1;
                    result = s.substring(i, j + 1);
                }
                i--;
                j++;
            } else {
                return;
            }
        }
    }

    //Manacher
    public String longestPalindrome1(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        String str = processStr(s);
        int len = str.length();
        int[] P = new int[len];
        int C = 0, R = 0;
        for (int i = 1; i < len - 1; i++) {
            int mi = 2 * C - i;
            P[i] = (R > i) ? Math.min(R - i, P[mi]) : 0;

            int a = i + P[i]+1, b=i - P[i]-1;
            while (b>=0 && a<=len-1 && str.charAt(a) == str.charAt(b)) {
                P[i]++;
                a = i + P[i]+1;
                b=i - P[i]-1;
            }
            if (i + P[i] > R) {
                C = i;
                R = i + P[i];
            }
        }
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < len - 1; i++) {
            if (P[i] > maxLen) {
                maxLen = P[i];
                centerIndex = i;
            }
        }
        int index = (centerIndex - maxLen) / 2;
        return s.substring(index, index+maxLen);
    }

    private String processStr(String s) {
        StringBuilder sb = new StringBuilder("#");
        for (char c : s.toCharArray()) {
            sb.append(c).append("#");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring test = new LongestPalindromicSubstring();
        //ccc
        System.out.println(test.longestPalindrome("ccc"));
        //a
        System.out.println(test.longestPalindrome("ac"));
        //bb
        System.out.println(test.longestPalindrome("abbc"));
        String s = "dsfsdhadhfkdsdsfsdhadhdsfsdhadhfkddsfsdhadhfkdsahfksadhdsfsdhadhfkdsahfksadhfksddsfsdhadhfkdsahfksadhfksdhfusdihfksjadfhksadjkdsahfdsjkhfksdhffhiawoeuruihweiyrtiuoncsdbfzmbfkhfioaewncfhskdsfsdhadhfkdsahfksadhfksdhfusdihfksjadfhksadjkdsahfdsjkhfksdhffhiawoeuruihweiyrtiuoncsdbfzmbfkhfioaewncfhskhfusdihfksjadfhksadjkdsahfdsjkhfksdhffhiawoeuruihweiyrtiuoncsdbfzmbfkhfioaewncfhskdsfsdhadhfkdsahfksadhfksdhfusdihfksjadfhksadjkdsahfdsjkhfksdhffhiawoeuruihweiyrtiuoncsdbfzmbfkhfioaewncfhskdsfsdhadhfkdsahfksadhfksdhfusdihfksjadfhksadjkdsahfdsjkhfksdhffhiawoeuruihweiyrtiuoncsdbfzmbfkhfioaewncfhskdsfsdhadhfkdsahfksadhfksdhfusdihfksjadsfsdhadhfkdsahfksadhfksdhfusdihfksjadfhksadjkdsahfdsjkhfksdhffhiawoeuruihweiyrtiuoncsdbfzmbfkhfioaewncfhskdsfsdhadhfkdsahfksadhfksdhfusdihfksjadfhksadjkdsahfdsjkhfksdhffhiawoeuruihweiyrtiuoncsdbfzmbfkhfioaewncfhskdfhksadjkdsahfdsjkhfksdhffhiawoeuruihweiyrtiuoncsdbfzmbfkhfioaewncfhskfdsfsdhadhfkdsahfksadhfksdhfusdihfksjadfhksadjkdsahfdsjkhfksdhffhiawoeuruihweiyrtiuoncsdbfzmbfkhfioaewncfhskksdhfusdihfksjadfhksadjkdsahfdsjkhfksdhffhiawoeuruihweiyrtiuoncsdbfzmbfkhfioaewncfhsksahfksadhfksdhfusdihfksjadfhksadjkdsahfdsjkhfksdhffhiawoeuruihweiyrtiuoncsdbfzmbfkhfioaewncfhskfkdsahfksadhfksdhfusdihfksjadfhksadjkdsahfdsjkhfksdhffhiawoeuruihweiyrtiuoncsdbfzmbfkhfioaewncfhskahfksadhfksdhfusdihfksjadfhksadjkdsahfdsjkhfksdhffhiawoeuruihweiyrtiuoncsdbfzmbfkhfioaewncfhsk";
        System.out.println(test.longestPalindrome(s));


        //ccc
        System.out.println(test.longestPalindrome1("ccc"));
        //a
        System.out.println(test.longestPalindrome1("ac"));
        //bb
        System.out.println(test.longestPalindrome1("abbc"));

        System.out.println(test.longestPalindrome1(s));
        System.out.println(test.longestPalindrome1("sababacss"));
    }
}
