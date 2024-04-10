package com.leiqjl;

/**
 * 2073. Time Needed to Buy Tickets - Easy
 */
public class TimeNeededToBuyTickets {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {
                time = time + Math.min(tickets[i], tickets[k]);
            } else {
                time = time + Math.min(tickets[i], tickets[k] - 1);
            }
        }
        return time;
    }
}
