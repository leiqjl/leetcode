package com.leiqjl;

/**
 * 1344. Angle Between Hands of a Clock - Medium
 */
public class AngleBetweenHandsOfAClock {
    public double angleClock(int hour, int minutes) {
        double minuteAngle = 6.0 * minutes;
        double hourAngle = 30.0 * (hour % 12 + minutes / 60.0);
        double diff = Math.abs(hourAngle - minuteAngle);
        return Math.min(diff, 360.0 - diff);
    }
}
