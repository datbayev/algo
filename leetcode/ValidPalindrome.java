package leetcode;

// https://leetcode.com/problems/valid-palindrome/description/
// 125. Valid Palindrome

class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s.length() == 0)
            return true;
        
        s = s.replaceAll("\\W", "").toUpperCase();
        String reversed = new StringBuilder(s).reverse().toString();
        
        return s.equals(reversed);
    }
}
