package leetcode;

// https://leetcode.com/problems/minimum-window-subsequence/description/
// 727. Minimum Window Subsequence

import java.util.*;

public class MinimumWindowSubsequence {
    public String minWindow(String s, String t) {
        if (t.length() == 1)
            return s.contains(t) ? t : "";

        Map<Character, TreeSet<Integer>> map = new HashMap<>();
        int left = 0, right = Integer.MAX_VALUE, n = s.length(), m = t.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c))
                map.put(c, new TreeSet<>());

            map.get(c).add(i);

            if (i >= m - 1 && c == t.charAt(m - 1)) {
                int last = i - 1, j = m - 2;

                while (j >= 0) {
                    char cur = t.charAt(j);

                    TreeSet<Integer> set = map.get(cur);

                    if (set == null)
                        break;

                    Integer prev = set.floor(last);
                    if (prev == null)
                        break;

                    last = prev - 1;
                    j--;
                }

                if (j == -1 && (right == Integer.MAX_VALUE || right - left > i - last + 1)) {
                    left = last + 1;
                    right = i;
                }
            }
        }

        return right == Integer.MAX_VALUE ? "" : s.substring(left, right + 1);
    }
}
