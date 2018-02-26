package leetcode;

// https://leetcode.com/problems/longest-palindromic-substring/description/
// 5. Longest Palindromic Substring

class LongestPalindromicSubstring {
    private int start = 0, end = 0, max = 1;

    public String longestPalindrome(String s) {
        if (s.length() < 2)
            return s;

        for (int i = 0; i < s.length() - 1; i++) {
            find(i, i, s);
            find(i, i + 1, s); // for even length
        }

        return s.substring(start, end + 1);
    }

    private void find(int left, int right, String s) {
        if (left == right) { // odd length of possible palindrome
            left--;
            right++;
        }

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        left++; right--; // rollback last iteration

        if (right - left + 1 > max) {
            max = right - left + 1;
            start = left;
            end = right;
        }
    }
}
