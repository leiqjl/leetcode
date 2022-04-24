package com.leiqjl;

import java.util.HashMap;
import java.util.Map;

/**
 * 535. Encode and Decode TinyURL - Medium
 */
public class EncodeAndDecodeTinyURL {
    public class Codec {
        String host = "http://tinyurl.com/";
        private Map<String, String> map = new HashMap<>();
        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            String key = String.valueOf(longUrl.hashCode());
            map.put(key, longUrl);
            return host + key;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            String key = shortUrl.replace(host, "");
            return map.get(key);
        }
    }
}
