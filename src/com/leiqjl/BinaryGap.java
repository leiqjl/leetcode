package com.leiqjl;

/**
 * 868. Binary Gap - Easy
 */
public class BinaryGap {
    public int binaryGap(int n) {
        int result = 0;
        int lastOne = -1;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                if (lastOne != -1) {
                    result = Math.max(result, i - lastOne);
                }
                lastOne = i;
            }
        }
        return result;
    }
}
