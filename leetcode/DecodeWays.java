package leetcode;

// https://leetcode.com/problems/decode-ways/description/
// 91. Decode Ways

class DecodeWays {
    boolean fatal = false;
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0)
            return 0;
        
        if (s.charAt(0) == '0')
            return 0;
        
        int[] d = new int[n + 1];
        d[0] = 1;
        d[1] = 1;
        for (int i = 2; i <= n; i++) {
            d[i] = d[i - 1];
            if (isOk(s.charAt(i - 2), s.charAt(i - 1)) && s.charAt(i - 1) != '0') {
                if (i < n && s.charAt(i) != '0' || i == n) {
                    d[i] += d[i - 2];
                }
            }
            
            if (fatal)
                return 0;
        }
        
        return d[n];
    }
    
    private boolean isOk(char c1, char c2) {
        if (c1 == '0' && c2 == '0') {
            fatal = true;
            return false;
        }
        
        if (c1 >= '3' && c1 <= '9' && c2 == '0') {
            fatal = true;
            return false;
        }
        
        if (c1 == '0')
            return false;
        
        String str = "" + c1 + c2;
        int x = Integer.parseInt(str);
        return x >= 10 && x <= 26;
    }

    public int numDecodings2(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            if (s.charAt(i-1) >= '1' && s.charAt(i-1) <= '9')
                dp[i] = dp[i-1];
            if (i > 1) {
                if (s.charAt(i-2) == '1' || s.charAt(i-2) == '2' && s.charAt(i-1) <= '6') {
                    dp[i] += dp[i-2];
                }
            }
        }
        return dp[n];
    }
}
