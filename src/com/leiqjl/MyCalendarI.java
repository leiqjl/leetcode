package com.leiqjl;

import java.util.TreeMap;

/**
 * 729. My Calendar I - Medium
 */
public class MyCalendarI {
    class MyCalendar {
        TreeMap<Integer, Integer> treeMap;

        public MyCalendar() {
            treeMap = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            Integer prevKey = treeMap.lowerKey(end);
            if (prevKey == null || treeMap.get(prevKey) <= start) {
                treeMap.put(start, end);
                return true;
            }
            return false;
        }
    }
}
