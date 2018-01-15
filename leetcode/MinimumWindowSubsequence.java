package leetcode;

// https://leetcode.com/problems/minimum-window-subsequence/description/
// 727. Minimum Window Subsequence

public class MinimumWindowSubsequence {
    public String minWindow(String s, String t) {
        boolean[][] d = new boolean[t.length()][s.length()];
        for (int i = 0; i < t.length(); i++)
            for (int j = 0; j < s.length(); j++)
                if (t.charAt(i) == s.charAt(j))
                    d[i][j] = true;

        int i = 0, j = 0, jj = 0, min = Integer.MAX_VALUE, minIndex = -1;

        while (i < t.length() && j < s.length()) {
            if (d[i][j]) {
                i++;
                j++;

                if (i == t.length()) {
                    if (min > j - jj) {
                        min = j - jj;
                        minIndex = jj;
                    }
                    j = jj + 1;
                    jj++;
                    i = 0;
                }
            } else
                j++;
        }

        return minIndex == -1 ? "" : s.substring(minIndex, minIndex + min);
    }
}
