package leetcode;

// https://leetcode.com/problems/longest-absolute-file-path
// 388. Longest Absolute File Path

class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        int max = 0;

        String[] lines = input.split("\n");
        int[] stack = new int[lines.length + 1]; // stack[i] - length of i-th line
        for (String line : lines) {
            int level = line.lastIndexOf("\t") + 1; // how many times "tabbed"
            int cur = stack[level] + line.length() - level + 1;

            stack[level + 1] = cur;

            if (line.contains("."))
                max = Math.max(max, cur - 1);
        }

        return max;
    }
}
