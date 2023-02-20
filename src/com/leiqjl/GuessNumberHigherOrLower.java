package com.leiqjl;

/**
 * 374. Guess Number Higher or Lower - Easy
 */
public class GuessNumberHigherOrLower {
    //1 <= n <= 231 - 1
    //1 <= pick <= n
    public int guessNumber(int n) {
        int l = 1, r = n;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == 1) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    //You call a pre-defined API int guess(int num), which returns three possible results:
    //
    //-1: Your guess is higher than the number I picked (i.e. num > pick).
    //1: Your guess is lower than the number I picked (i.e. num < pick).
    //0: your guess is equal to the number I picked (i.e. num == pick).
    private int guess(int num) {
        return 0;
    }
}
