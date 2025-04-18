package com.leiqjl;

/***
 * 38. Count and Say - Medium
 */
public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        StringBuilder s = new StringBuilder("1");
        for (int i = 2; i <= n; i++) {
            s = countAndSay(s);
        }
        return s.toString();
    }

    private StringBuilder countAndSay(StringBuilder s) {
        StringBuilder cur = new StringBuilder();
        char c = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != c) {
                cur.append(count).append(c);
                c = s.charAt(i);
                count = 1;
            } else {
                count++;
            }
        }
        cur.append(count).append(c);
        return cur;
    }

    public static void main(String[] args) {
        CountAndSay c = new CountAndSay();
        assert c.countAndSay(1).equals("1");
        assert c.countAndSay(4).equals("1211");
    }

}
