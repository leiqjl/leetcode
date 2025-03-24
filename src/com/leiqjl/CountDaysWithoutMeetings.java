package com.leiqjl;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 3169. Count Days Without Meetings - Medium
 * You are given a positive integer days representing the total number of days an employee is available for work (starting from day 1).
 * You are also given a 2D array meetings of size n where, meetings[i] = [start_i, end_i] represents the starting and ending days of meeting i (inclusive).
 * <p>
 * Return the count of days when the employee is available for work but no meetings are scheduled.
 * <p>
 * Note: The meetings may overlap.
 */
public class CountDaysWithoutMeetings {
    //Constraints:
    //
    //1 <= days <= 10^9
    //1 <= meetings.length <= 10^5
    //meetings[i].length == 2
    //1 <= meetings[i][0] <= meetings[i][1] <= days
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        int end = 0, day = 0;
        for (int[] meeting : meetings) {
            if (end + 1 < meeting[0]) {
                day = day + (meeting[0] - end - 1);
                end = meeting[1];
            } else {
                end = Math.max(end, meeting[1]);
            }
        }
        day = day + (days - end);
        return day;
    }

    public static void main(String[] args) {
        CountDaysWithoutMeetings c = new CountDaysWithoutMeetings();
        //Input: days = 10, meetings = [[5,7],[1,3],[9,10]]
        //Output: 2
        //Explanation:
        //There is no meeting scheduled on the 4th and 8th days.
        assert c.countDays(10, new int[][]{{5, 7}, {1, 3}, {9, 10}}) == 2;
        //Input: days = 5, meetings = [[2,4],[1,3]]
        //Output: 1
        //Explanation:
        //There is no meeting scheduled on the 5th day.
        assert c.countDays(5, new int[][]{{2, 4}, {1, 3}}) == 1;
        //Input: days = 6, meetings = [[1,6]]
        //Output: 0
        //Explanation:
        //Meetings are scheduled for all working days.
        assert c.countDays(6, new int[][]{{1, 6}}) == 0;
    }
}
