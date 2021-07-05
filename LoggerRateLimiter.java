// Time Complexity : O(1)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

/*
 * 1. Maintain a map to have last timestamp for each message
 * 2. for every message check time difference and return boolean value.
 */

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {
	Map<String, Integer> map;

	/** Initialize your data structure here. */
	    public LoggerRateLimiter() {
	        map = new HashMap<>();
	    }

	/**
	 * Returns true if the message should be printed in the given timestamp,
	 * otherwise returns false. If this method returns false, the message will not
	 * be printed. The timestamp is in seconds granularity.
	 */
	public boolean shouldPrintMessage(int timestamp, String message) {
		if (map.containsKey(message)) {
			int ts = map.get(message) + 10;
			if (ts <= timestamp) {
				map.put(message, timestamp);
				return true;
			} else {
				return false;
			}
		} else {
			map.put(message, timestamp);
			return true;
		}

	}
}
