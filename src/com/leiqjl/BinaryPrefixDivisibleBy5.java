package com.leiqjl;

import java.util.ArrayList;
import java.util.List;

/**
 * 1018. Binary Prefix Divisible By 5 - Easy
 */
public class BinaryPrefixDivisibleBy5 {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> res = new ArrayList<>();
        int cur = 0;
        for (int num : nums) {
            cur = ((cur << 1) + num) % 5;

            res.add(cur == 0);
        }
        return res;
    }
}
