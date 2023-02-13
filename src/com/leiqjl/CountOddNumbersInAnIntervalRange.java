package com.leiqjl;

/**
 * 1523. Count Odd Numbers in an Interval Range - Easy
 */
public class CountOddNumbersInAnIntervalRange {
    public int countOdds(int low, int high) {
        //count(1 ~ high) - count(1 ~ low-1)
        return (high + 1) / 2 - low / 2;
    }
}
