package com.leiqjl;

import java.util.Arrays;

/**
 * 1465. Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts - Medium
 */
public class MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts {

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        return (int) (getMax(h, horizontalCuts) * getMax(w, verticalCuts) % 1000000007);
    }

    private long getMax(int h, int[] arr) {
        Arrays.sort(arr);
        int max = Math.max(arr[0], h - arr[arr.length - 1]);
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i] - arr[i - 1]);
        }
        return max;
    }

}
