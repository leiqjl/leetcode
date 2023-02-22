package com.leiqjl;

/**
 * 2299. Strong Password Checker II - Easy
 * A password is said to be strong if it satisfies all the following criteria:
 * <p>
 * - It has at least 8 characters.
 * - It contains at least one lowercase letter.
 * - It contains at least one uppercase letter.
 * - It contains at least one digit.
 * - It contains at least one special character. The special characters are the characters in the following string: "!@#$%^&*()-+".
 * - It does not contain 2 of the same character in adjacent positions (i.e., "aab" violates this condition, but "aba" does not).
 * Given a string password, return true if it is a strong password. Otherwise, return false.
 */
public class StrongPasswordCheckerII {
    public boolean strongPasswordCheckerII(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        boolean special = false, lowercase = false, uppercase = false, digit = false;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (i > 0 && c == password.charAt(i - 1)) {
                return false;
            }
            if (Character.isUpperCase(c)) {
                uppercase = true;
            } else if (Character.isLowerCase(c)) {
                lowercase = true;
            } else if (Character.isDigit(c)) {
                digit = true;
            } else {
                special = true;
            }
        }
        return lowercase && uppercase && digit && special;
    }

    public static void main(String[] args) {
        StrongPasswordCheckerII s = new StrongPasswordCheckerII();
        //Input: password = "IloveLe3tcode!"
        //Output: true
        //Explanation: The password meets all the requirements. Therefore, we return true.
        assert s.strongPasswordCheckerII("IloveLe3tcode!");
        //Input: password = "Me+You--IsMyDream"
        //Output: false
        //Explanation: The password does not contain a digit and also contains 2 of the same character in adjacent positions. Therefore, we return false.
        assert !s.strongPasswordCheckerII("Me+You--IsMyDream!");
        //Input: password = "1aB!"
        //Output: false
        //Explanation: The password does not meet the length requirement. Therefore, we return false.
        assert !s.strongPasswordCheckerII("1aB!");
    }
}
