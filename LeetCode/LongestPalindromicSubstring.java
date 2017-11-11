// https://leetcode.com/problems/longest-palindromic-substring/description/
// 5. Longest Palindromic Substring

class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int maxlen = 0;
        String res = "";
        
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            String s1 = find(i, i, s);
            String s2 = i < n - 1 && s.charAt(i) == s.charAt(i + 1) ? find(i, i + 1, s) : "";
            
            if (maxlen < Math.max(s1.length(), s2.length())) {
                res = s1.length() > s2.length() ? s1 : s2;
                maxlen = res.length();
            }
        }
        
        return res;
    }
    
    public String find(int ind1, int ind2, String s) {
        int l = ind1, r = ind2;
        while (l >= 0 && r <= s.length() - 1) {
            if (s.charAt(l) != s.charAt(r))
                break;
            l--;
            r++;
        }
        
        return s.substring(l + 1, r);
    }
}
