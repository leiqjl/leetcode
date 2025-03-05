package com.leiqjl;

/**
 * 2579. Count Total Number of Colored Cells - Medium
 * There exists an infinitely large two-dimensional grid of uncolored unit cells. You are given a positive integer n, indicating that you must do the following routine for n minutes:
 * <p>
 * ·At the first minute, color any arbitrary unit cell blue.
 * ·Every minute thereafter, color blue every uncolored cell that touches a blue cell.
 * <p>
 * Below is a pictorial representation of the state of the grid after minutes 1, 2, and 3.
 */
public class CountTotalNumberOfColoredCells {
    // 1            1
    // 1+4 = 5      2    1+ 4 + ...+(4 * (n-1)) = 1 + 4* n(n-1)/2
    //1+4+8 = 13    3           0 0 1 0 0
    //1+4+8+12 = 25 4           0 1 1 1 0
    //                          1 1 1 1 1
    //                          0 1 1 1 0
    //                          0 0 1 0 0
    public long coloredCells(int n) {
        return 2L * n * (n - 1) + 1;
    }

    public static void main(String[] args) {
        CountTotalNumberOfColoredCells c = new CountTotalNumberOfColoredCells();
        assert c.coloredCells(1) == 1;
        assert c.coloredCells(2) == 5;
    }
}
