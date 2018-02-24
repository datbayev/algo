package leetcode;

// https://leetcode.com/problems/count-and-say
// 38. Count and Say

class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1)
            return "1";

        char[] prev = countAndSay(n - 1).toCharArray();
        StringBuilder res = new StringBuilder("");

        char c = prev[0];
        int count = 1;

        for (int i = 1; i < prev.length; i++) {
            if (prev[i] == c)
                count++;
            else {
                res.append(count).append(c);
                count = 1;
                c = prev[i];
            }
        }

        res.append(count).append(c);
        return res.toString();
    }
}
