package com.leiqjl;

/**
 * 983. Minimum Cost For Tickets - Medium
 */
public class MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int maxDay = days[days.length - 1];
        int[] dp = new int[maxDay + 1];
        int index = 0;
        for (int i = 1; i <= maxDay; i++) {
            if (index < days.length && i == days[index]) {
                dp[i] = Math.min(dp[i - 1] + costs[0], Math.min(dp[Math.max(i - 7, 0)] + costs[1], dp[Math.max(i - 30, 0)] + costs[2]));
                index++;
            } else {
                dp[i] = dp[i - 1];
            }

        }
        return dp[maxDay];
    }

    public static void main(String[] args) {
        MinimumCostForTickets m = new MinimumCostForTickets();
        //Input: days = [1,4,6,7,8,20], costs = [2,7,15]
        //Output: 11
        //Explanation: For example, here is one way to buy passes that lets you travel your travel plan:
        //On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
        //On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
        //On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
        //In total, you spent $11 and covered all the days of your travel.
        assert m.mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15}) == 11;
        //Input: days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
        //Output: 17
        assert m.mincostTickets(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31}, new int[]{2, 7, 15}) == 17;
    }
}
