package com.leiqjl;

/**
 * 2264. Largest 3-Same-Digit Number in String - Easy
 */
public class Largest3SameDigitNumberInString {
    public String largestGoodInteger(String num) {
        char c = '0' - 1;
        for (int i = 0; i <= num.length() - 3; i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                c = (char) Math.max(c, num.charAt(i));
            }
        }
        return c < '0' ? "" : String.valueOf(c).repeat(3);
    }

    public static void main(String[] args) {
        Largest3SameDigitNumberInString l = new Largest3SameDigitNumberInString();
        assert l.largestGoodInteger("6777133339").equals("777");
        assert l.largestGoodInteger("2300019").equals("000");
        assert l.largestGoodInteger("42352338").equals("");
        assert l.largestGoodInteger("222").equals("222");
    }
}
