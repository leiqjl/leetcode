package com.leiqjl;

/**
 * 990. Satisfiability of Equality Equations - Medium
 */
public class SatisfiabilityOfEqualityEquations {

    public boolean equationsPossible(String[] equations) {
        int[] uf = new int[26];
        for (int i = 0; i < 26; i++) {
            uf[i] = i;
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                uf[find(equation.charAt(0) - 'a', uf)] = find(equation.charAt(3) - 'a', uf);
            }
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                if (find(equation.charAt(0) - 'a', uf) == find(equation.charAt(3) - 'a', uf)) {
                    return false;
                }
            }
        }
        return true;
    }

    private int find(int x, int[] uf) {
        while (uf[x] != x) {
            uf[x] = uf[uf[x]];
            x = uf[x];
        }
        return x;
    }

}
