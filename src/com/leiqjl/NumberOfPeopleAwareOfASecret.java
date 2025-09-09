package com.leiqjl;

/**
 * 2327. Number of People Aware of a Secret - Medium
 */
public class NumberOfPeopleAwareOfASecret {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long mod = 1000000007;
        long[] shareArr = new long[n + 1];
        long[] forgetArr = new long[n + 1];
        long canShare = 0;
        long known = 1;
        if (delay < n) {
            shareArr[delay + 1] = 1;
        }
        if (forget < n) {
            forgetArr[forget + 1] = 1;
        }

        for (int i = delay + 1; i <= n; i++) {
            canShare = (canShare + shareArr[i] - forgetArr[i] + mod) % mod;

            known = (known - forgetArr[i] + mod) % mod;
            known = (known + canShare) % mod;

            if (i + delay < n + 1) {
                shareArr[i + delay] = (shareArr[i + delay] + canShare) % mod;
            }
            if (i + forget < n + 1) {
                forgetArr[i + forget] = (forgetArr[i + forget] + canShare) % mod;
            }
        }
        return (int) (known % mod);
    }
    public static void main(String[] args) {
        NumberOfPeopleAwareOfASecret n = new NumberOfPeopleAwareOfASecret();
        assert n.peopleAwareOfSecret(6, 2, 4) == 5;
        assert n.peopleAwareOfSecret(4, 1, 3) == 6;
        assert n.peopleAwareOfSecret(684, 18, 496) == 653668527;
    }
}
