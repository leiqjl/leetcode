package com.leiqjl;

/**
 * 2513. Minimize the Maximum of Two Arrays - Medium
 * <p>
 * We have two arrays arr1 and arr2 which are initially empty. You need to add positive integers to them such that they satisfy all the following conditions:
 * <p>
 * - arr1 contains uniqueCnt1 distinct positive integers, each of which is not divisible by divisor1.
 * - arr2 contains uniqueCnt2 distinct positive integers, each of which is not divisible by divisor2.
 * - No integer is present in both arr1 and arr2.
 * <p>
 * Given divisor1, divisor2, uniqueCnt1, and uniqueCnt2, return the minimum possible maximum integer that can be present in either array
 */
public class MinimizeTheMaximumOfTwoArrays {
    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        //lcm(a,b)*gcd(a,b)=a*b
        long lcm = ((long) divisor1 / gcd(divisor1, divisor2)) * divisor2;
        long left = 1, right = Integer.MAX_VALUE;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (uniqueCnt1 <= (mid - mid / divisor1) && uniqueCnt2 <= (mid - mid / divisor2) && (uniqueCnt1 + uniqueCnt2) <= (mid - mid / lcm)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return (int) left;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int minimizeSet1(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        long r1 = getEnd(uniqueCnt1, divisor1);
        long r2 = getEnd(uniqueCnt2, divisor2);

        long lcm = ((long) divisor1 / gcd(divisor1, divisor2)) * divisor2;
        long r3 = getEnd(uniqueCnt1 + uniqueCnt2, lcm);
        return (int) Math.max(r1, Math.max(r2, r3));
    }
    private long getEnd(long count, long d) {
        return count + count / (d - 1) - (count % (d - 1) == 0 ? 1 : 0);
    }


    public static void main(String[] args) {
        MinimizeTheMaximumOfTwoArrays m = new MinimizeTheMaximumOfTwoArrays();
        //Input: divisor1 = 2, divisor2 = 7, uniqueCnt1 = 1, uniqueCnt2 = 3
        //Output: 4
        //arr1 = [1] and arr2 = [2,3,4]
        assert m.minimizeSet(2, 7, 1, 3) == 4;
        //Input: divisor1 = 3, divisor2 = 5, uniqueCnt1 = 2, uniqueCnt2 = 1
        //Output: 3
        //Explanation:
        //Here arr1 = [1,2], and arr2 = [3]
        assert m.minimizeSet(3, 5, 2, 1) == 3;
        assert m.minimizeSet(94560, 71250, 30680567, 87765279) == 118445846;
        assert m.minimizeSet(92761, 48337, 208563424, 9115778) == 217679202;
    }
}
