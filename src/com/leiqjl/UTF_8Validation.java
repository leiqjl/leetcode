package com.leiqjl;

/**
 * 393. UTF-8 Validation - Medium
 */
public class UTF_8Validation {
    public boolean validUtf8(int[] data) {
        int mask = 1 << 7;
        int mask1 = 1 << 6;
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            if (count == 0) {
                int temp = 1 << 7;
                while ((data[i] & temp) != 0) {
                    count++;
                    temp >>= 1;
                }
                if (count == 0) {
                    continue;
                }
                if (count > 4 || count == 1) {
                    return false;
                }
            } else {
                if (!((data[i] & mask) != 0 && (data[i] & mask1) == 0)) {
                    return false;
                }
            }
            count--;
        }
        return count == 0;
    }

    public static void main(String[] args) {
        UTF_8Validation u = new UTF_8Validation();
        //Input: data = [197,130,1]   11000101 10000010 00000001
        //Output: true
        assert u.validUtf8(new int[]{197, 130, 1});
        //Input: data = [235,140,4]   11101011 10001100 00000100
        //Output: false
        assert !u.validUtf8(new int[]{235, 140, 4});
    }
}
