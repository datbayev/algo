package leetcode;

// https://leetcode.com/problems/minimum-window-substring/description/
// 76. Minimum Window Substring

import java.util.*;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> count = new HashMap<>();
        int left = 0, right = Integer.MAX_VALUE;

        for (char ch : t.toCharArray()) {
            if (count.containsKey(ch))
                count.put(ch, count.get(ch) + 1);
            else
                count.put(ch, 1);
        }

        // i - left index, j - right index
        // [i <-> j] - sliding window
        int i = 0, j = 0, cur = 0;

        while (j < s.length()) {
            char c = s.charAt(j);
            if (count.containsKey(c)) {
                count.put(c, count.get(c) - 1);

                if (count.get(c) >= 0)
                    cur++;

                while (cur == t.length()) { // solution found

                    if (right == Integer.MAX_VALUE || right - left > j - i) {
                        left = i;
                        right = j;
                    }

                    if (count.containsKey(s.charAt(i))) {
                        count.put(s.charAt(i), count.get(s.charAt(i)) + 1);

                        if (count.get(s.charAt(i)) > 0) // left char which was in "T" is now out of window
                            cur--;
                    }

                    i++;
                }
            }

            j++;
        }

        return right != Integer.MAX_VALUE ? s.substring(left, right + 1) : "";
    }
}
