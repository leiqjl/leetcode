package com.leiqjl;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1356. Sort Integers by The Number of 1 Bits - Easy
 */
public class SortIntegersByTheNumberOf1Bits {
    public int[] sortByBits(int[] arr) {
        return Arrays.stream(arr)
                .boxed()
                .sorted(Comparator
                        .comparingInt(Integer::bitCount)
                        .thenComparingInt(a -> a))
                .mapToInt(Integer::intValue)
                .toArray();
    }

}
