package com.leiqjl;

/**
 * 1323. Maximum 69 Number - Easy
 */
public class Maximum69Number {
    public int maximum69Number(int num) {
        int a = 10000;
        while (a > 0) {
            if ((num / a) % 10 == 6) {
                num += 3 * a;
                break;
            }
            a /= 10;
        }
        return num;
    }
}
