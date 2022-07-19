package com.leiqjl;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. Pascal's Triangle - Easy
 */
public class PascalsTriangle {
    //1 <= numRows <= 30
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> dp = new ArrayList<>(numRows);
        List<Integer> first = new ArrayList<>(1);
        first.add(1);
        dp.add(first);
        for (int i = 2; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>(numRows);
            List<Integer> last = dp.get(i - 2);
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    list.add(1);
                    continue;
                }
                list.add(last.get(j - 1) + last.get(j));
            }
            dp.add(list);
        }
        return dp;
    }
}
