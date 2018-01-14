package leetcode;

// https://leetcode.com/problems/meeting-rooms-ii/
// 253. Meeting Rooms II

import java.util.*;

class MeetingRoomsII {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals.length < 2)
            return intervals.length;

        Queue<Event> pq = new PriorityQueue(intervals.length * 2, new Comparator<Event>() {
            @Override
            public int compare(Event e1, Event e2) {
                if (e1.time == e2.time) {
                    if (!e2.start)
                        return 1;
                    else if (!e1.start)
                        return -1;
                    else
                        return 0;
                } else {
                    return e1.time - e2.time;
                }
            }
        });

        for (Interval cur : intervals) {
            pq.add(new Event(cur.start, true));
            pq.add(new Event(cur.end, false));
        }

        int max = 0, started = 0;
        while (!pq.isEmpty()) {
            Event cur = pq.poll();
            if (cur.start)
                started++;
            else
                started--;
            max = Math.max(max, started);
        }

        return max;
    }

    class Event {
        int time;
        boolean start;

        public Event(int time, boolean start) {
            this.time = time;
            this.start = start;
        }
    }

    class Interval {
        int start;
        int end;
        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
