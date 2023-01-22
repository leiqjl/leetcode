package com.leiqjl;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. Restore IP Addresses - Medium
 */
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            return result;
        }
        int n = s.length();
        for (int i = 1; i < 4 && i < n - 2; i++) {
            for (int j = i + 1; j < i + 4 && i < n - 1; j++) {
                for (int k = j + 1; k < j + 4 && k < n; k++) {
                    String a = s.substring(0, i);
                    String b = s.substring(i, j);
                    String c = s.substring(j, k);
                    String d = s.substring(k);
                    if (isValid(a) && isValid(b) && isValid(c) && isValid(d)) {
                        result.add(a + "." + b + "." + c + "." + d);
                    }
                }
            }
        }
        return result;
    }

    private boolean isValid(String ip) {
        if ((ip.length() > 1 && ip.charAt(0) == '0') || Integer.parseInt(ip) > 255) {
            return false;
        }
        return true;
    }
}
