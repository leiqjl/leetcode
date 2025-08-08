package com.leiqjl;

import java.util.HashMap;
import java.util.Map;

/**
 * 808. Soup Servings - Medium
 */
public class SoupServings {
    //Answers within 10^-5 of the actual answer will be accepted.
    public double soupServings(int n) {
        int o = (int) Math.ceil(n / 25.0);
        Map<Integer, Map<Integer, Double>> dp = new HashMap<>();
        for (int i = 1; i <= o; i++) {
            if (cal(i, i, dp) > 1 - 1e-5) {
                return 1.0;
            }
        }
        return cal(o, o, dp);
    }

    //a <= 0 b <= 0   both ran out 0.5
    //a <= 0 b > 0   a ran out 1
    //a > 0  b <= 0   b ran out 0.0
    private double cal(int a, int b, Map<Integer, Map<Integer, Double>> dp) {
        if (a <= 0 && b <= 0) {
            return 0.5;
        }
        if (a <= 0) {
            return 1.0;
        }
        if (b <= 0) {
            return 0.0;
        }
        if (dp.containsKey(a) && dp.get(a).containsKey(b)) {
            return dp.get(a).get(b);
        }
        double cur = (cal(a - 4, b, dp) + cal(a - 3, b - 1, dp) + cal(a - 2, b - 2, dp) + cal(a - 1, b - 3, dp)) / 4.0;
        dp.computeIfAbsent(a, t -> new HashMap<>()).put(b, cur);
        return cur;
    }
}
