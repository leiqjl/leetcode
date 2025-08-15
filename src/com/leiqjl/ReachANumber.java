package com.leiqjl;

/**
 * 754. Reach a Number - Medium
 */
public class ReachANumber {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int sum = 0, numMoves = 0;
        while (sum < target) {
            numMoves++;
            sum += numMoves;
        }
        sum -= target;
        if ((sum & 1) == 1) {
            numMoves = numMoves + 1 + numMoves % 2;
        }
        return numMoves;
    }

    public static void main(String[] args) {
        ReachANumber r = new ReachANumber();
        assert r.reachNumber(2) == 3;
        assert r.reachNumber(3) == 2;
    }
}
