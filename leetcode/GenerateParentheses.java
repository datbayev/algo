package leetcode;

// https://leetcode.com/problems/generate-parentheses/description/
// 22. Generate Parentheses

import java.util.*;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        rec("", 0, 0, n, res);
        return res;
    }

    private void rec(String cur, int left, int right, int n, List<String> res) {
        if (right > left || right > n || left > n)
            return;

        if (left == n && right == n)
            res.add(cur);

        rec(cur + "(", left + 1, right, n, res);
        rec(cur + ")", left, right + 1, n, res);
    }
}
