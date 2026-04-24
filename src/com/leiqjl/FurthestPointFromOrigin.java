package com.leiqjl;

/**
 * 2833. Furthest Point From Origin - Easy
 */
public class FurthestPointFromOrigin {

    public int furthestDistanceFromOrigin(String moves) {
        int lCount = 0, rCount = 0, _Count = 0;
        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'L':
                    lCount++;
                    break;
                case 'R':
                    rCount++;
                    break;
                default:
                    _Count++;
            }
        }
        return Math.abs(lCount - rCount) + _Count;
    }
}
