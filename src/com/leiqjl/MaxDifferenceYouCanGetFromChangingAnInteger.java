package com.leiqjl;

/**
 * 1432. Max Difference You Can Get From Changing an Integer - Medium
 */
public class MaxDifferenceYouCanGetFromChangingAnInteger {
    public int maxDiff(int num) {
        String maxStr = String.valueOf(num);
        String minStr = maxStr;
        int n = maxStr.length();
        for (int i = 0; i < n; i++) {
            char c = maxStr.charAt(i);
            if (c != '9') {
                maxStr = maxStr.replace(c, '9');
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            char c = minStr.charAt(i);
            if (i == 0) {
                if (c != '1') {
                    minStr = minStr.replace(c, '1');
                    break;
                }
            } else {
                if (c != '0' && c != maxStr.charAt(0)) {
                    minStr = minStr.replace(c, '0');
                    break;
                }
            }
        }
        return Integer.parseInt(maxStr) - Integer.parseInt(minStr);
    }
}
