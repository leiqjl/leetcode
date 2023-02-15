package com.leiqjl;

import java.util.HashMap;
import java.util.Map;

/**
 * 1797. Design Authentication Manager - Medium
 */
public class DesignAuthenticationManager {
    class AuthenticationManager {
        int life;
        Map<String, Integer> timeMap = new HashMap<>();

        //constructs the AuthenticationManager and sets the timeToLive
        public AuthenticationManager(int timeToLive) {
            this.life = timeToLive;
        }

        // generates a new token with the given tokenId at the given currentTime in seconds.
        public void generate(String tokenId, int currentTime) {
            timeMap.put(tokenId, currentTime + life);
        }

        // renews the unexpired token with the given tokenId at the given currentTime in seconds.
        // If there are no unexpired tokens with the given tokenId, the request is ignored, and nothing happens.
        public void renew(String tokenId, int currentTime) {
            clean(currentTime);
            timeMap.computeIfPresent(tokenId, (k, v) -> currentTime + life);
        }

        //returns the number of unexpired tokens at the given currentTime.
        public int countUnexpiredTokens(int currentTime) {
            clean(currentTime);
            return timeMap.size();
        }

        private void clean(int currentTime) {
            timeMap.entrySet().removeIf(e -> e.getValue() <= currentTime);
        }
    }
}
