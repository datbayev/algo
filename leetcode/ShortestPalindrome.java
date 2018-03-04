package leetcode;

// https://leetcode.com/problems/shortest-palindrome/description/
// 214. Shortest Palindrome

public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        if (s.length() < 2)
            return s;

        char[] ch = s.toCharArray();
        int right = ch.length - 1;
        while (right > 0 && !isPalindrome(ch, 0, right))
            right--;

        StringBuilder sb = new StringBuilder(s);
        for (int i = right + 1; i < ch.length; i++)
            sb.insert(0, ch[i]);

        return sb.toString();
    }

    private boolean isPalindrome(char[] ch, int left, int right) {
        while (left <= right) {
            if (ch[left++] != ch[right--])
                return false;
        }

        return true;
    }
}
