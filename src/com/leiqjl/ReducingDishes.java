package com.leiqjl;

import java.util.Arrays;

/**
 * 1402. Reducing Dishes - Hard
 */
public class ReducingDishes {
    //Constraints:
    //
    //n == satisfaction.length
    //1 <= n <= 500
    //-1000 <= satisfaction[i] <= 1000
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n = satisfaction.length;
        if (satisfaction[n - 1] < 0) {
            return 0;
        }
        int cur = satisfaction[n - 1];
        int sum = cur;
        int max = sum;
        for (int i = n - 2; i >= 0; i--) {
            sum += satisfaction[i];
            cur += sum;
            if (cur > max) {
                max = cur;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ReducingDishes r = new ReducingDishes();
        //Input: satisfaction = [-1,-8,0,5,-9]
        //Output: 14
        //Explanation: After Removing the second and last dish, the maximum total like-time coefficient will be equal to (-1*1 + 0*2 + 5*3 = 14).
        //Each dish is prepared in one unit of time.
        assert r.maxSatisfaction(new int[]{-1, -8, 0, 5, -9}) == 14;
        //Input: satisfaction = [4,3,2]
        //Output: 20
        //Explanation: Dishes can be prepared in any order, (2*1 + 3*2 + 4*3 = 20)
        assert r.maxSatisfaction(new int[]{4, 3, 2}) == 20;
        //Input: satisfaction = [-1,-4,-5]
        //Output: 0
        //Explanation: People do not like the dishes. No dish is prepared.
        assert r.maxSatisfaction(new int[]{-1, -4, -5}) == 0;
    }
}
