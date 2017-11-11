// https://leetcode.com/problems/palindromic-substrings/description/
// 647. Palindromic Substrings

class PalindromicSubstrings {
    char[] c;
    public int countSubstrings(String s) {
        c = s.toCharArray();
        int n = c.length;
        int[] d = new int[n];
        d[0] = 1;
        
        for (int i = 1; i < n; i++) {
            d[i] = d[i - 1] + 1 + sum(i);
        }
        
        return d[n - 1];
    }
    
    public int sum(int pos) {
        int res = 0;
        
        for (int i = 0; i < pos; i++)
            if (c[i] == c[pos] && isPalindrome(i, pos))
                res++;
        
        return res;
    }
    
    public boolean isPalindrome(int start, int end) {
        int l = start;
        int r = end;
        while (l <= r) {
            if (c[l] != c[r])
                return false;
            l++;
            r--;
        }
        
        return true;
    }
}
