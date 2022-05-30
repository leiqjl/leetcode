package com.leiqjl;

/**
 * 1342. Number of Steps to Reduce a Number to Zero - Easy
 */
public class NumberOfStepsToReduceANumberToZero {
    //0 <= num <= 10^6
    public int numberOfSteps(int num) {
        int count = 0;
        while (num != 0) {
            if ((num & 1) == 1) {
                num--;
            } else {
                num >>>= 1;
            }
            count++;
        }
        return count;
    }
}
