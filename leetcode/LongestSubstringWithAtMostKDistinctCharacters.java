package leetcode;

// https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/description/
// 340. Longest Substring with At Most K Distinct Characters

import java.util.ArrayDeque;

public class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k > s.length())
            return s.length();

        // binary search
        // left = k, right = len(s)
        int left = k, right = s.length(), max = k;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (isPossible(s.toCharArray(), mid, k)) {
                left = mid + 1;
                max = Math.max(max, mid);
            } else {
                right = mid - 1;
            }
        }

        return max;
    }

    // is it possible to find a substring from s with length len with at most k different chars
    private boolean isPossible(char[] c, int len, int k) {
        ArrayDeque<Character> q = new ArrayDeque<>();
        int[] count = new int[128];
        int uniq = 0;

        for (int i = 0; i < c.length; i++) {
            if (count[c[i]] == 0)
                uniq++;

            count[c[i]]++;
            q.add(c[i]);

            if (i < len - 1) // we're trying to make a sliding window of length "len"
                continue;

            if (uniq <= k) // at this moment we have at most k unique chars in our string
                return true;

            count[q.peekFirst()]--;
            if (count[q.peekFirst()] == 0)
                uniq--;

            q.pollFirst();
        }

        return false;
    }
}
