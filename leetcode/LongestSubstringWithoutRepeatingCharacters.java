package leetcode;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
// 3. Longest Substring Without Repeating Characters

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2)
            return s.length();

        char[] c = s.toCharArray();
        int left = 1, right = s.length(), max = 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isPossible(mid, c)) {
                left = mid + 1;
                max = Math.max(max, mid);
            } else {
                right = mid - 1;
            }
        }

        return max;
    }

    // is it possible to have "len" substring in c
    private boolean isPossible(int len, char[] c) {
        Set<Character> set = new HashSet<>();
        ArrayDeque<Character> q = new ArrayDeque<>();
        int[] count = new int[128];

        for (int i = 0; i < c.length; i++) {
            q.add(c[i]);
            set.add(c[i]);
            count[c[i]]++;

            if (i < len - 1)
                continue;

            if (q.size() == set.size()) // all chars are unique in the queue
                return true;

            char cur = q.peekFirst();

            count[cur]--;
            if (count[cur] == 0)
                set.remove(cur);

            q.pollFirst();
        }

        return q.size() == set.size() && set.size() == len;
    }
}
