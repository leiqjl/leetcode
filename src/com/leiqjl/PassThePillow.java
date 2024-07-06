package com.leiqjl;

/**
 * 2582. Pass the Pillow - Easy
 */
public class PassThePillow {
    public int passThePillow(int n, int time) {
        int num = time / (n - 1);
        int move = time % (n - 1);
        if ((num & 1) == 0) {
            return 1 + move;
        } else {
            return n - move;
        }
    }
}
