package com.leiqjl;

import java.util.Arrays;

/**
 * 739. Daily Temperatures - Medium
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
 * If there is no future day for which this is possible, keep answer[i] == 0 instead.
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        int[] stack = new int[temperatures.length];
        int idx = -1;
        for (int i = 0; i < temperatures.length; i++) {
            while (idx > -1 && temperatures[i] > temperatures[stack[idx]]) {
                result[stack[idx]] = i - stack[idx];
                idx--;
            }
            idx++;
            stack[idx] = i;
        }
        return result;
    }

    public static void main(String[] args) {
        DailyTemperatures d = new DailyTemperatures();
        assert "[1, 1, 4, 2, 1, 1, 0, 0]".equals(Arrays.toString(d.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
        assert "[1, 1, 1, 0]".equals(Arrays.toString(d.dailyTemperatures(new int[]{30, 40, 50, 60})));
        assert "[1, 1, 0]".equals(Arrays.toString(d.dailyTemperatures(new int[]{30, 60, 90})));
    }
}
