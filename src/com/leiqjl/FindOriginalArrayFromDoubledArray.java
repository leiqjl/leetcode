package com.leiqjl;

/**
 * 2007. Find Original Array From Doubled Array - Medium
 */
public class FindOriginalArrayFromDoubledArray {

    //1 <= changed.length <= 10^5
    //0 <= changed[i] <= 10^5
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n % 2 == 1) {
            return new int[0];
        }
        int[] result = new int[n / 2];
        int[] counter = new int[100000];
        for (int c : changed) {
            counter[c]++;
        }
        int idx = 0;
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] == 0) {
                continue;
            }
            if (i * 2 > 100000 || counter[i] > counter[i * 2]) {
                return new int[0];
            }
            for (int j = 0; j < counter[i]; j++) {
                counter[i * 2]--;
                result[idx++] = i;
            }
        }
        return result;
    }

}
