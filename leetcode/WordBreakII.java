package leetcode;

// https://leetcode.com/problems/word-break-ii/description/
// 140. Word Break II

import java.util.*;

class WordBreakII {
    List<List<String>> res;
    List<String> output;
    Set<String> set;
    String s;
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        this.s = s;
        set = new HashSet(wordDict);
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
        
        res = new ArrayList();        
        output = new ArrayList();
        
        rec(new ArrayList(), dp, n);
        processResults();
        
        return output;
    }
    
    public void processResults() {
        for (List<String> curList : res) {
            if (curList.size() == 0)
                continue;
            String cur = curList.get(0);
            for (int i = 1; i < curList.size(); i++) 
                cur = curList.get(i) + " " + cur;
            output.add(cur);
        }
    }
    
    public void rec(List<String> curList, boolean[] dp, int n) {
        if (n == 0) {
            res.add(curList);
            return;
        }
        
        int i = 0; 
        while (i <= s.length()) {
            if (dp[n] && (n - i >= 0) && set.contains(s.substring(n - i, n))) {
                List<String> newList = new ArrayList(curList);
                newList.add(s.substring(n - i, n));
                rec(newList, dp, n - i);
            }
            
            i++;
        }
    }
}
