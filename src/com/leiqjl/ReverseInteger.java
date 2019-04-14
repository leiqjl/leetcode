package com.leiqjl;

public class ReverseInteger {
    public int reverse(int x) {
        int result = 0;
        int pre = 0;
        int temp = 0;
        while (x != 0) {
            temp = x % 10;
            result = result * 10 + temp;
            //overflow
            if ((result - temp) / 10 != pre) {
                return 0;
            }
            pre = result;
            x /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseInteger test = new ReverseInteger();
        //123 -> 321
        System.out.println(test.reverse(123));
        //120 -> 21
        System.out.println(test.reverse(120));
        //-123 -> -321
        System.out.println(test.reverse(-123));
        //1534236469 -> 0
        System.out.println(test.reverse(1534236469));
    }
}
