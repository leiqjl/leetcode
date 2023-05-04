package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 649. Dota2 Senate - Medium
 */
public class Dota2Senate {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> rQueue = new ArrayDeque<>();
        Queue<Integer> dQueue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                rQueue.add(i);
            } else {
                dQueue.add(i);
            }
        }

        while (!rQueue.isEmpty() && !dQueue.isEmpty()) {
            int rIdx = rQueue.remove();
            int dIdx = dQueue.remove();
            if (rIdx < dIdx) {
                rQueue.add(rIdx + n);
            } else {
                dQueue.add(dIdx + n);
            }
        }
        return rQueue.isEmpty() ? "Dire" : "Radiant";
    }

    public static void main(String[] args) {
        Dota2Senate d = new Dota2Senate();
        assert d.predictPartyVictory("RD").equals("Radiant");
        assert d.predictPartyVictory("RDD").equals("Dire");
        assert d.predictPartyVictory("DDRRR").equals("Dire");
    }
}
