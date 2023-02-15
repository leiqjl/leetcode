package com.leiqjl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 989. Add to Array-Form of Integer - Easy
 */
public class AddToArrayFormOfInteger {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>(num.length + 1);
        int i = num.length - 1;
        while (i >= 0 && k > 0) {
            k += num[i];
            result.add(k % 10);
            k /= 10;
            i--;
        }
        while (i >= 0) {
            result.add(num[i]);
            i--;
        }
        while (k > 0) {
            result.add(k % 10);
            k /= 10;
        }
        Collections.reverse(result);
        return result;
    }
}
