package com.leiqjl;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 2402. Meeting Rooms III - Hard
 */
public class MeetingRoomsIII {
    //Constraints:
    //
    //1 <= n <= 100
    //1 <= meetings.length <= 10^5
    //meetings[i].length == 2
    //0 <= starti < endi <= 5 * 10^5
    //All the values of starti are unique.
    public int mostBooked(int n, int[][] meetings) {
        int[] count = new int[n];
        PriorityQueue<Integer> minFreeRoomsHeap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            minFreeRoomsHeap.offer(i);
        }
        PriorityQueue<long[]> minUsedRoomsHeap = new PriorityQueue<>((a, b) -> a[0] != b[0] ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1]));
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        for (int[] meeting : meetings) {
            int startTime = meeting[0];
            int endTime = meeting[1];
            while (!minUsedRoomsHeap.isEmpty() && minUsedRoomsHeap.peek()[0] <= startTime) {
                minFreeRoomsHeap.offer((int) minUsedRoomsHeap.poll()[1]);
            }

            if (minFreeRoomsHeap.isEmpty()) {
                long[] poll = minUsedRoomsHeap.poll();
                int room = (int) poll[1];
                minUsedRoomsHeap.offer(new long[]{poll[0] + endTime - startTime, room});
                count[room]++;
            } else {
                int room = minFreeRoomsHeap.poll();
                minUsedRoomsHeap.offer(new long[]{endTime, room});
                count[room]++;
            }
        }
        int max = 0, room = -1;
        for (int i = 0; i < n; i++) {
            if (count[i] > max) {
                max = count[i];
                room = i;
            }
        }
        return room;
    }

    public static void main(String[] args) {
        MeetingRoomsIII m = new MeetingRoomsIII();
        //Input: n = 2, meetings = [[0,10],[1,5],[2,7],[3,4]]
        //Output: 0
        assert m.mostBooked(2, new int[][]{{0, 10}, {1, 5}, {2, 7}, {3, 4}}) == 0;
        //Input: n = 3, meetings = [[1,20],[2,10],[3,5],[4,9],[6,8]]
        //Output: 1
        assert m.mostBooked(3, new int[][]{{1, 20}, {2, 10}, {3, 5}, {4, 9}, {6, 8}}) == 1;
    }
}
