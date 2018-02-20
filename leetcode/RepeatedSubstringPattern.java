package leetcode;

// https://leetcode.com/problems/repeated-substring-pattern/description/
// 459. Repeated Substring Pattern

public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        if (s.length() < 2)
            return false;

        for (int repeat = 1; repeat <= s.length() / 2; repeat++) {
            if (s.length() % repeat > 0)
                continue;

            boolean ok = true;
            int i = 0;

            while (i < repeat) {
                char c = s.charAt(i);
                int j = i;

                while (j < s.length()) {
                    if (s.charAt(j) != c) {
                        ok = false;
                        break;
                    }

                    j += repeat;
                }

                if (!ok)
                    break;

                i++;
            }

            if (ok)
                return true;
        }

        return false;
    }
}
