package com.leiqjl;

/**
 * 3612. Process String with Special Operations I - Medium
 */
public class ProcessStringWithSpecialOperationsI {
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '*':
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    break;
                case '#':
                    sb.append(sb);
                    break;
                case '%':
                    sb.reverse();
                    break;
                default:
                    sb.append(c);
            }
        }
        return sb.toString();
    }
}
