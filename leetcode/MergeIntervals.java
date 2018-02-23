package leetcode;

// https://leetcode.com/problems/merge-intervals
// 56. Merge Intervals

import java.util.*;

public class MergeIntervals {

    public class Interval {
        int start;
        int end;
        Interval(int s, int e) {start = s; end = e;}
        Interval() {start = 0; end = 0;}
        public String toString() { return String.format("%s %s", start, end); }
    }

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0)
            return new ArrayList<>();

        List<Interval> res = new ArrayList<>();
        intervals.sort((a, b) -> a.start != b.start ? Integer.compare(a.start, b.start) : Integer.compare(a.end, b.end));

        int i = 0;
        while (i < intervals.size()) {
            int curmax = intervals.get(i).end;
            int j = i + 1;
            while (j < intervals.size() && intervals.get(j).start <= curmax) {
                curmax = Math.max(curmax, intervals.get(j).end);
                j++;
            }

            res.add(new Interval(intervals.get(i).start, curmax));

            i = j;
        }

        return res;
    }
}
