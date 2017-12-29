package leetcode;

// https://leetcode.com/problems/open-the-lock/description/
// 753. Open the Lock

import java.util.*;

public class OpenTheLock {
    public int openLock(String[] deadends, String target) {
        Map<String, Integer> map = new HashMap();
        LinkedList<String> q = new LinkedList();
        Set<String> dead = new HashSet();
        Set<String> set = new HashSet();

        boolean found = false;
        String init = "0000";

        for (String s : deadends)
            dead.add(s);

        q.add(init);
        set.add(init);
        map.put(init, 0);

        while (!q.isEmpty()) {
            String cur = q.poll();

            if (dead.contains(cur))
                continue;

            if (cur.equals(target)) {
                found = true;
                break;
            }

            StringBuilder next = new StringBuilder(cur);

            for (int i = 3; i >= 0; i--) {
                int num = cur.charAt(i) - '0';

                next.setCharAt(i, num < 9 ? (char)(num + 1 + '0') : '0');
                if (!set.contains(next.toString()) && !dead.contains(next.toString())) {
                    q.add(next.toString());
                    set.add(next.toString());
                    map.put(next.toString(), map.get(cur) + 1);
                }

                next.setCharAt(i, num > 0 ? (char)(num - 1 + '0') : '9');
                if (!set.contains(next.toString()) && !dead.contains(next.toString())) {
                    q.add(next.toString());
                    set.add(next.toString());
                    map.put(next.toString(), map.get(cur) + 1);
                }

                next.setCharAt(i, cur.charAt(i));
            }
        }

        return found && map.containsKey(target) ? map.get(target) : -1;
    }
}
