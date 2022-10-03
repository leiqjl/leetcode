package com.leiqjl;

/**
 * 838. Push Dominoes - Medium
 */
public class PushDominoes {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int[] arr = new int[n];
        int val = 0;
        for (int i = 0; i < n; i++) {
            if (dominoes.charAt(i) == 'R') {
                val = n;
            } else if (dominoes.charAt(i) == 'L') {
                val = 0;
            } else {
                val = Math.max(val - 1, 0);
            }
            arr[i] += val;
        }
        val = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (dominoes.charAt(i) == 'L') {
                val = n;
            } else if (dominoes.charAt(i) == 'R') {
                val = 0;
            } else {
                val = Math.max(val - 1, 0);
            }
            arr[i] -= val;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i] > 0 ? 'R' : (arr[i] == 0 ? '.' : 'L'));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        PushDominoes p = new PushDominoes();
        //Input: dominoes = "RR.L"
        //Output: "RR.L"
        assert p.pushDominoes("RR.L").equals("RR.L");
        //Input: dominoes = ".L.R...LR..L.."
        //Output: "LL.RR.LLRRLL.."
        assert p.pushDominoes(".L.R...LR..L..").equals("LL.RR.LLRRLL..");
    }
}
