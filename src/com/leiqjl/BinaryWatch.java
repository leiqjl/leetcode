package com.leiqjl;

import java.util.ArrayList;
import java.util.List;

/**
 * 401. Binary Watch - Easy
 */
public class BinaryWatch {
    //0 <= turnedOn <= 10
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 1024; i++) {
            int hour = i >> 6;
            int minute = i & 63;
            if (Integer.bitCount(i) == turnedOn && hour < 12 && minute < 60) {
                res.add(String.format("%d:%02d", hour, minute));
            }
        }
        return res;
    }
}
