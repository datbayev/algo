package leetcode;

// https://leetcode.com/problems/minimum-time-difference/description/
// 539. Minimum Time Difference

import java.util.*;

public class MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        int min = Integer.MAX_VALUE;

        Collections.sort(timePoints);
        timePoints.add(timePoints.get(0));

        for (int i = 0; i < timePoints.size() - 1; i++)
            min = Math.min(min, diff(timePoints.get(i), timePoints.get(i + 1)));

        return min;
    }

    private int diff(String t1, String t2) {
        int min1 = timeToMin(t1);
        int min2 = timeToMin(t2);
        int res = Math.abs(min1 - min2);
        return Math.min(res, 1440 - res);
    }

    private int timeToMin(String t) {
        String[] time = t.split(":");
        return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
    }
}
