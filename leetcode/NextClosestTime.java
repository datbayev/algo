package leetcode;

// https://leetcode.com/problems/next-closest-time/description/
// 681. Next Closest Time

import java.util.*;

public class NextClosestTime {
    public String nextClosestTime(String time) {
        Set<Integer> allowed = new HashSet<>();
        for (char c : time.toCharArray())
            if (c != ':')
                allowed.add(c - '0');

        int cur = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));

        while (true) {
            cur = (cur + 1) % (24 * 60);
            int[] dig = new int[]{cur / 60 / 10, cur / 60 % 10, cur % 60 / 10, cur % 60 % 10};
            boolean flag = true;

            for (int d : dig) {
                if (!allowed.contains(d)) {
                    flag = false;
                    break;
                }
            }

            if (flag)
                return String.format("%d%d:%d%d", cur / 60 / 10, cur / 60 % 10, cur % 60 / 10, cur % 60 % 10);
        }
    }
}
