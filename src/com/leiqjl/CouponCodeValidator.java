package com.leiqjl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 3606. Coupon Code Validator - Easy
 */
public class CouponCodeValidator {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        Map<String, Integer> priorityMap = new HashMap<>();
        priorityMap.put("electronics", 0);
        priorityMap.put("grocery", 1);
        priorityMap.put("pharmacy", 2);
        priorityMap.put("restaurant", 3);
        List<String[]> list = new ArrayList<>();
        for (int i = 0; i < code.length; i++) {
            if (!isActive[i]) {
                continue;
            }
            if (!isValidCode(code[i])) {
                continue;
            }
            if (!isValidBusinessLine(businessLine[i], priorityMap)) {
                continue;
            }
            list.add(new String[]{code[i], businessLine[i]});
        }
        list.sort((a, b) -> {
            int priorityA = priorityMap.get(a[1]);
            int priorityB = priorityMap.get(b[1]);
            if (priorityA == priorityB) {
                return a[0].compareTo(b[0]);
            }
            return Integer.compare(priorityA, priorityB);
        });
        List<String> result = new ArrayList<>();
        for (String[] coupon : list) {
            result.add(coupon[0]);
        }
        return result;
    }

    private boolean isValidBusinessLine(String line, Map<String, Integer> priorityMap) {
        if (line == null || line.isEmpty()) {
            return false;
        }
        return priorityMap.containsKey(line);
    }

    private boolean isValidCode(String code) {
        if (code == null || code.isEmpty()) {
            return false;
        }
        for (char c : code.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && c != '_') {
                return false;
            }
        }
        return true;
    }
}
