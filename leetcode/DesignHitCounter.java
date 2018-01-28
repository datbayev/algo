package leetcode;

// https://leetcode.com/problems/design-hit-counter/description/
// 362. Design Hit Counter

public class DesignHitCounter {
    int[] hits;
    int[] times;

    /** Initialize your data structure here. */
    public DesignHitCounter() {
        hits = new int[300];
        times = new int[300];
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int index = timestamp % 300;

        if (times[index] != timestamp) { // same %300 hits happened more than 300 seconds ago
            times[index] = timestamp;
            hits[index] = 1;
        } else {
            hits[index]++; // same time multiple hits
        }
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int res = 0;

        for (int i = 0; i < 300; i++)
            if (timestamp - times[i] < 300)
                res += hits[i];

        return res;
    }
}
