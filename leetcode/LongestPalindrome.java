package leetcode;

// https://leetcode.com/problems/longest-palindrome/description/
// 409. Longest Palindrome

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int res = 0;

        int[] ch = new int[128];
        for (char c : s.toCharArray())
            ch[c]++;

        int odds = 0;
        for (int i = 0; i < 128; i++) {
            if (ch[i] % 2 == 0)
                res += ch[i];
            else {
                if (ch[i] > 0) {
                    odds++;
                    res += ch[i] - 1;
                }
            }
        }

        if (odds > 0)
            res++;

        return res;
    }
}
