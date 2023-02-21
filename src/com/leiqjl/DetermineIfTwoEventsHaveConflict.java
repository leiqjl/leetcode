package com.leiqjl;

/**
 * 2446. Determine if Two Events Have Conflict - Easy
 */
public class DetermineIfTwoEventsHaveConflict {
    public boolean haveConflict(String[] event1, String[] event2) {
        return !(event1[1].compareTo(event2[0]) < 0 || event2[1].compareTo(event1[0]) < 0);
    }
}
