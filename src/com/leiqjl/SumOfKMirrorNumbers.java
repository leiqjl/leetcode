package com.leiqjl;

import java.util.ArrayList;
import java.util.List;

/**
 * 2081. Sum of k-Mirror Numbers - Hard
 */
public class SumOfKMirrorNumbers {
    //2 <= k <= 9
    //1 <= n <= 30
    public long kMirror(int k, int n) {
        long ans = 0;
        long len = 1;
        while (n > 0) {
            for (long i = len; i < len * 10 && n > 0; i++) {
                long palindrome = getPalindrome(i, true);
                if (isPalindrome(palindrome, k)) {
                    ans += palindrome;
                    n--;
                }
            }
            for (long i = len; i < len * 10 && n > 0; i++) {
                long palindrome = getPalindrome(i, false);
                if (isPalindrome(palindrome, k)) {
                    ans += palindrome;
                    n--;
                }
            }
            len *= 10;
        }
        return ans;
    }

    private long getPalindrome(long num, boolean isOdd) {
        long temp = num;
        if (isOdd) {
            temp /= 10;
        }
        while (temp > 0) {
            num = num * 10 + temp % 10;
            temp /= 10;
        }
        return num;
    }

    private boolean isPalindrome(long num, int k) {
        List<Integer> list = new ArrayList<>();
        while (num > 0) {
            list.add((int) (num % k));
            num /= k;
        }
        int i = 0, j = list.size() - 1;
        while (i <= j) {
            if (list.get(i) != list.get(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        SumOfKMirrorNumbers s = new SumOfKMirrorNumbers();
        assert s.kMirror(2, 5) == 25;
        assert s.kMirror(3, 7) == 499;
        assert s.kMirror(7, 17) == 20379000;
    }
}
