package com.leiqjl;

/**
 * 790. Domino and Tromino Tiling - Medium
 */
public class DominoAndTrominoTiling {
    // ·
    // · F(N-1)
    //··
    //·· F(N-2)
    // ··   ··
    // ···   ·    F_up(N-1)
    //            F_down(N-1)
    // F(N) = F(N-1)+F(N-2)+F_up(N-1)+F_down(N-1)
    // F_up(N)=F_down(N-1)+F(N-2)
    // F_down(N)=F_up(N-1)+F(N-2)
    // F(N) = F(N-1)+F(N-2)+F_up(N-1)+F_down(N-1)
    //      = F(N-1)+F(N-2)+F_down(N-2)+F(N-3)+F_up(N-2)+F(N-3)
    //      = F(N-1)+F(N-3)+[F(N-2)+F(N-3)+F_up(N-2)+F_down(N-2)]
    //      = 2F(N-1)+F(N-3)
    public int numTilings(int n) {
        if (n <= 2) {
            return n;
        } else if (n == 3) {
            return 5;
        }
        int three = 1, two = 2, one = 5;
        for (int i = 4; i <= n; i++) {
            int temp = (int)((2L * one + three) % 1_000_000_007);
            three = two;
            two = one;
            one = temp;
        }
        return one;
    }
}
