package leetcode;

// https://leetcode.com/problems/longest-common-prefix/description/
// 14. Longest Common Prefix

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";

        StringBuilder res = new StringBuilder();

        int n = strs.length;
        boolean stop = false;

        for (int len = 0; len < strs[0].length(); len++) {
            res.append(strs[0].charAt(len));

            for (int i = 1; i < n; i++) {
                if (!strs[i].startsWith(res.toString())) {
                    res.deleteCharAt(len);
                    stop = true;
                    break;
                }
            }

            if (stop)
                break;
        }

        return res.toString();
    }
}
