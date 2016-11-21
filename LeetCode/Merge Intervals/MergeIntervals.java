import java.util.*;

public class MergeIntervals {

    public class Interval {
        int start;
        int end;
        Interval(int s, int e) {start = s; end = e;}
        Interval() {start = 0; end = 0;}
        public String toString() { return String.format("%s %s", start, end); }
    }

    Comparator<Interval> intervalComparator = new Comparator<Interval>() {
        @Override
        public int compare(Interval o1, Interval o2) {
            if (o1.start < o2.start)
                return -1;
            else if (o1.start > o2.start)
                return 1;
            else { // starts are equal
                if (o1.end < o2.end)
                    return -1;
                else if (o1.end > o2.end)
                    return 1;
                else
                    return 0;
            }
        }
    };

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();

        Collections.sort(intervals, intervalComparator);

        int i = 0;
        while (i < intervals.size()) {
            Interval curElem = intervals.get(i);
            Interval currentInterval = new Interval(curElem.start, curElem.end);
            int j = i + 1;
            int lastEnd = curElem.end;
            while (j < intervals.size() && intervals.get(j).start <= lastEnd) {
                if (lastEnd < intervals.get(j).end)
                    lastEnd = intervals.get(j).end;
                j++;
            }
            currentInterval.end = lastEnd;
            result.add(currentInterval);
            i = j;
        }
        return result;
    }
}
