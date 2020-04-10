package com.leiqjl;

public class Sqrt {

    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        int left = 2;
        int right = x/2;
        int mid,tmp;
        while (left <= right) {
            mid = left + (right-left)/2;
            tmp = x/mid;
            if (mid == tmp) {
                return mid;
            } else if (mid < tmp) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return right;
    }
}
