// https://leetcode.com/problems/longest-continuous-increasing-subsequence/description/
// 674. Longest Continuous Increasing Subsequence

class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        
        int max = 1;
        int cur = 1;
        int x = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (x < nums[i])
                cur++;
            else
                cur = 1;
            
            x = nums[i];
            
            if (max < cur)
                max = cur;
        }
        
        return max;
    }
}
