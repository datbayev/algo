package leetcode;

// https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/
// 673. Number of Longest Increasing Subsequence

class NumberOfLongestIncreasingSubsequence {
    
    public int findNumberOfLIS(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        
        int[] count = new int[2001];
        int[] d = new int[2001];
        int maxLen = 0;
        int res = 0;
        
        for (int i = 0; i < nums.length; i++) {
            d[i] = 1;
            count[i] = 1;
            
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    
                    if (d[i] == d[j] + 1)
                        count[i] += count[j];
                    
                    if (d[i] < d[j] + 1) {
                        d[i] = d[j] + 1;
                        count[i] = count[j];
                    }
                }
            }
            
            if (maxLen == d[i])
                res += count[i];
            
            if (maxLen < d[i]) {
                maxLen = d[i];
                res = count[i];
            }
        }
        
        return res;
    }
}
