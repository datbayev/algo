package leet_code;

// https://leetcode.com/problems/word-break/description/
// 139. Word Break

import java.util.*;

class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> set = new HashSet(wordDict);
        boolean[] dp = new boolean[n + 1];
        
        dp[0] = true; // possible for size zero
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // try to split "s" into two substrings: s[0..j] and s[j..i]
                if (dp[j] && set.contains(s.substring(j, i))) { 
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[n];
    }
}
