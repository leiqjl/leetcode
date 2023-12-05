package com.leiqjl;

/**
 * 1688. Count of Matches in Tournament - Easy
 */
public class CountOfMatchesInTournament {
    public int numberOfMatches(int n) {
        return n - 1;
    }
//    public int numberOfMatches(int n) {
//        int res = 0;
//        while (n > 1) {
//            res += n >> 1;
//            n = n - (n >> 1);
//        }
//        return res;
//    }

    public static void main(String[] args) {
        CountOfMatchesInTournament c = new CountOfMatchesInTournament();
        assert c.numberOfMatches(7) == 6;
        assert c.numberOfMatches(14) == 13;
    }
}
