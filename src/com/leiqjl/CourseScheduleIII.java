package com.leiqjl;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 630. Course Schedule III - Hard
 * <p>
 * There are n different online courses numbered from 1 to n.
 * You are given an array courses where courses[i] = [durationi, lastDayi] indicate that the ith course should be taken continuously for durationi days and must be finished before or on lastDayi.
 * <p>
 * You will start on the 1st day and you cannot take two or more courses simultaneously.
 * <p>
 * Return the maximum number of courses that you can take.
 */
public class CourseScheduleIII {

    public int scheduleCourse(int[][] courses) {
        // sort by lastDay
        Arrays.sort(courses, Comparator.comparingInt(x -> x[1]));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        int time = 0;
        for (int[] course : courses) {
            if (time + course[0] <= course[1]) {
                time += course[0];
                pq.add(course[0]);
            } else if (!pq.isEmpty() && pq.peek() > course[0]) {
                time = time + course[0] - pq.remove();
                pq.add(course[0]);
            }
        }
        return pq.size();
    }
}
