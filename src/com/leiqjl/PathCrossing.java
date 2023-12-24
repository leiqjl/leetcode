package com.leiqjl;

import java.util.HashSet;

/**
 * 1496. Path Crossing - Easy
 */
public class PathCrossing {

    //Constraints:
    //
    //1 <= path.length <= 10^4
    //path[i] is either 'N', 'S', 'E', or 'W'.
    public boolean isPathCrossing(String path) {
        int x = 0, y = 0;
        HashSet<Integer> seen = new HashSet<>();
        seen.add(0);
        for (char c : path.toCharArray()) {
            switch (c) {
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
                    break;
                default:
                    return false;
            }
            if (!seen.add(x * 20001 + y)) {
                return true;
            }
        }
        return false;
    }
}
