package com.leiqjl;

/**
 * 997. Find the Town Judge - Easy
 */
public class FindTheTownJudge {

    public int findJudge(int n, int[][] trust) {
        int[] arr = new int[n+1];
        for (int[] t : trust) {
            arr[t[0]]--;
            arr[t[1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (arr[i] == n-1) {
                return i;
            }
        }
        return -1;
    }

}
