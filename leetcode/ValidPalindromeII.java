package leetcode;

// https://leetcode.com/problems/valid-palindrome-ii/
// 680. Valid Palindrome II

public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        return rec(s.toCharArray(), 0, s.length() - 1, 1);
    }

    private boolean rec(char[] c, int left, int right, int max) {
        if (max < 0)
            return false;

        while (left < right) {
            if (c[left] != c[right])
                return rec(c, left, right - 1, max - 1) || rec(c, left + 1, right, max - 1);

            right--;
            left++;
        }

        return true;
    }
}
