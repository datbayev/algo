package leetcode;

// https://leetcode.com/problems/next-closest-time/description/
// 681. Next Closest Time

public class NextClosestTime {
    int minAhead = Integer.MAX_VALUE;
    int maxBehind = Integer.MIN_VALUE;
    int midnight = 1440;

    String nextAhead;
    String nextBehind;

    boolean isAhead = false;

    public String nextClosestTime(String time) {
        String hours = time.split(":")[0];
        String minutes = time.split(":")[1];
        String res = time;

        if (hours.charAt(0) == hours.charAt(1) && minutes.charAt(0) == minutes.charAt(1) && minutes.charAt(0) == hours.charAt(0))
            return time;

        String noColonTime = hours + minutes;
        rec("", noColonTime);

        if (minAhead != Integer.MAX_VALUE)
            res = nextAhead;
        else if (maxBehind != Integer.MIN_VALUE)
            res = nextBehind;
        else
            return time;

        return res.substring(0, 2) + ":" + res.substring(2, 4);
    }

    private void rec(String cur, String time) {
        if (cur.equals(time))
            return;

        if (cur.length() >= 4) {
            if (isValidTime(cur)) {
                int curDiff = diff(cur, time);

                if (curDiff > 0) { // "cur" is ahead of "time"
                    if (minAhead > curDiff) {
                        minAhead = curDiff;
                        nextAhead = cur;
                    }
                } else { // "cur" is behind of "time"
                    if (maxBehind < -curDiff) {
                        maxBehind = -curDiff;
                        nextBehind = cur;
                    }
                }
            }

            return;
        }

        for (int i = 0; i < time.length(); i++)
            rec(cur + time.charAt(i), time);
    }

    private String minToTime(int total) {
        int hours = total / 60;
        int minutes = total - hours * 60;

        String h = hours < 10 ? "0" + hours : "" + hours;
        String m = minutes < 10 ? "0" + minutes : "" + minutes;

        return String.format("%s:%s", h, m);
    }

    private int diff(String t1, String t2) {
        int d1 = midnight - timeToInt(t1);
        int d2 = midnight - timeToInt(t2);

        int res = d2 - d1;

        return res;
    }

    private int timeToInt(String time) {
        String hours = time.substring(0, 2);
        String minutes = time.substring(2, 4);

        int res = Integer.parseInt(hours) * 60 + Integer.parseInt(minutes);

        return res;
    }

    public boolean isValidTime(String time) {
        String hours = time.substring(0, 2);
        String minutes = time.substring(2, 4);

        if (hours.compareTo("00") < 0 ||
                hours.compareTo("23") > 0 ||
                minutes.compareTo("00") < 0 ||
                minutes.compareTo("59") > 0)
        {
            return false;
        }

        return true;
    }
}
