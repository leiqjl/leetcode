package com.leiqjl;

/**
 * 443. String Compression - Medium
 */
public class StringCompression {
    //Constraints:
    //
    //1 <= chars.length <= 2000
    //chars[i] is a lowercase English letter, uppercase English letter, digit, or symbol.
    public int compress(char[] chars) {
        int i = 0, idx = 0;
        while (i < chars.length) {
            int count = 1;
            while (i + count < chars.length && chars[i] == chars[i + count]) {
                count++;
            }
            chars[idx++] = chars[i];
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[idx++] = c;
                }
            }
            i += count;
        }
        return idx;
    }

    public static void main(String[] args) {
        StringCompression s = new StringCompression();
        assert s.compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}) == 6;
        assert s.compress(new char[]{'a'}) == 1;
        assert s.compress(new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}) == 4;
    }
}
