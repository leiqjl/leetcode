package com.leiqjl;

public class CountAndSay {

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        StringBuilder cur = new StringBuilder("1");
        StringBuilder pre;
        char c;
        int count;
        for (int i = 1; i <n; i++) {
            pre = cur;
            cur = new StringBuilder();
            c = pre.charAt(0);
            count = 1;

            for (int j=1; j < pre.length(); j++) {
                if (pre.charAt(j) != c) {
                    cur.append(count).append(c);
                    c = pre.charAt(j);
                    count = 1;
                } else {
                    count++;
                }
            }
            cur.append(count).append(c);
        }
        return cur.toString();
    }

}
