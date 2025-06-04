package com.leiqjl;

/**
 * 3403. Find the Lexicographically Largest String From the Box I - Medium
 */
public class FindTheLexicographicallyLargestStringFromTheBoxI {
    public String answerString(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }
        String last = lastSubstring(word);
        int maxLen = word.length() - numFriends + 1;
        if (maxLen < last.length()) {
            last = last.substring(0, maxLen);
        }
        return last;
    }

    private String lastSubstring(String word) {
        int i = 0, j = 1, n = word.length();
        while (j < n) {
            int k = 0;
            while (j + k < n && word.charAt(i + k) == word.charAt(j + k)) {
                k++;
            }
            if (j + k < n && word.charAt(i + k) < word.charAt(j + k)) {
                //int t = i;
                //  i = j;
                //  j = Math.max(j + 1, t + k + 1);
                i = Math.max(i + k + 1, j);
                j = i + 1;
            } else {
                j = j + k + 1;
            }
        }
        return word.substring(i);
    }

    public static void main(String[] args) {
        FindTheLexicographicallyLargestStringFromTheBoxI f = new FindTheLexicographicallyLargestStringFromTheBoxI();
        assert f.answerString("dbca", 2).equals("dbc");
        assert f.answerString("gggg", 4).equals("g");
    }
}
