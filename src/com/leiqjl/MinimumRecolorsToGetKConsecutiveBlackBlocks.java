package com.leiqjl;

/**
 * 2379. Minimum Recolors to Get K Consecutive Black Blocks - Easy
 */
public class MinimumRecolorsToGetKConsecutiveBlackBlocks {
    //sliding window
    public int minimumRecolors(String blocks, int k) {
        int wCount = 0;
        int l = 0, r = 0;
        while (r < k) {
            if (blocks.charAt(r) == 'W') {
                wCount++;
            }
            r++;
        }
        int min = wCount;
        while (r < blocks.length()) {
            if (blocks.charAt(r) == 'W') {
                wCount++;
            }
            r++;
            if (blocks.charAt(l) == 'W') {
                wCount--;
            }
            l++;
            min = Math.min(min, wCount);
        }
        return min;
    }

    public static void main(String[] args) {
        MinimumRecolorsToGetKConsecutiveBlackBlocks m = new MinimumRecolorsToGetKConsecutiveBlackBlocks();
        assert m.minimumRecolors("WBBWWBBWBW", 7) == 3;
        assert m.minimumRecolors("WBWBBBW", 2) == 0;
    }
}
