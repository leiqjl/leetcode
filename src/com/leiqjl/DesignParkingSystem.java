package com.leiqjl;

/**
 * 1603. Design Parking System - Easy
 */
public class DesignParkingSystem {
    class ParkingSystem {
        int[] cars;

        public ParkingSystem(int big, int medium, int small) {
            cars = new int[]{big, medium, small};
        }

        public boolean addCar(int carType) {
            if (cars[carType-1] == 0) {
                return false;
            }
            cars[carType-1]--;
            return true;
        }
    }
}
