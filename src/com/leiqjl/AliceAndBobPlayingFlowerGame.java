package com.leiqjl;

/**
 * 3021. Alice and Bob Playing Flower Game - Medium
 */
public class AliceAndBobPlayingFlowerGame {

    // odd *  even  ⌈n/2⌉*⌊m/2⌋
    // even * odd   ⌊n/2⌋*⌈m/2⌉
    //⌈n/2⌉*⌊m/2⌋ + ⌊n/2⌋*⌈m/2⌉

    // x   y
    //even even    n/2 * m/2 + n/2 * m/2 = nm/2
    //odd  odd    (n+1)/2 * (m-1)/2 + (n-1)/2 * (m+1)/2 = (nm-1)/2
    //odd  even   (n+1)/2 * m/2 + (n-1)/2 * m/2 = nm/2
    //even odd.   n/2 * (m+1)/2 + n/2 * (m-1)/2 = nm/2
    public long flowerGame(int n, int m) {
        return (long) n * m / 2;
    }

    public static void main(String[] args) {
        AliceAndBobPlayingFlowerGame a = new AliceAndBobPlayingFlowerGame();
        assert a.flowerGame(3, 2) == 3;
        assert a.flowerGame(1, 1) == 0;
    }
}
