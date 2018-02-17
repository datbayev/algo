package leetcode;

// https://leetcode.com/problems/remove-invalid-parentheses/description/
// 301. Remove Invalid Parentheses

import java.util.*;

public class RemoveInvalidParentheses {
    int min = Integer.MAX_VALUE;

    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList();
        rec(s, res, 0, 0, new char[]{'(', ')'});
        return res;
    }

    private void rec(String s, List<String> res, int index, int lastRemoval, char[] par) {
        char open = par[0];
        char close = par[1];

        for (int stack = 0, i = index; i < s.length(); ++i) {
            if (s.charAt(i) == open) stack++;
            if (s.charAt(i) == close) stack--;
            if (stack >= 0) continue;

            // stack < 0, which means redundant ')'
            for (int j = lastRemoval; j <= i; j++)
                if (s.charAt(j) == close && (j == lastRemoval || s.charAt(j - 1) != close))
                    // go recursively with removed redundant ')'
                    rec(s.substring(0, j) + s.substring(j + 1, s.length()), res, i, j, par);

            return;
        }

        String reversed = new StringBuilder(s).reverse().toString();
        if (open == '(') // string was not reversed yet to possibly remove extra '('
            //rec(reversed, res, 0, 0, new char[]{')', '('});
            rec(reversed, res, 0, 0, new char[]{')', '('});
        else // has been reversed already in past, finished right to left
            res.add(reversed);
    }
}
