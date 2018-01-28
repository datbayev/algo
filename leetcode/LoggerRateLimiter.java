package leetcode;

// https://leetcode.com/problems/logger-rate-limiter/description/
// 359. Logger Rate Limiter

import java.util.*;

public class LoggerRateLimiter {
    Map<String, Integer> map; // message -> last time printed

    /** Initialize your data structure here. */
    public LoggerRateLimiter() {
        map = new HashMap();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!map.containsKey(message) || timestamp - map.get(message) >= 10) {
            map.put(message, timestamp);
            return true;
        }

        return false;
    }
}
