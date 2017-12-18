package leetcode;

// https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/discuss/
// 689. Maximum Sum of 3 Non-Overlapping Subarrays

class MaximumSumOf3NonOverlappingSubarrays {
    int n, k;
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        if (n < 1)
            return null;
        
        int curSum = 0;
        int[] sums = new int[nums.length];
        for (int i = 0; i < n; i++) {
            curSum += nums[i];
            sums[i] = curSum;
        }
        
        int[][] path = new int[4][nums.length + 1];
        int[][] dp = new int[4][nums.length + 1];
        
        for (int i = 1; i < 4; i++) {
            for (int j = k - 1; j < nums.length; j++) {
                int curMax = j - k < 0 ? sums[j] : sums[j] - sums[j - k] + dp[i - 1][j - k];
                
                if (j - k >= 0) {
                    dp[i][j] = dp[i][j - 1];
                    path[i][j] = path[i][j - 1];
                }
                
                if (j > 0 && curMax > dp[i][j - 1]) { // include new element
                    dp[i][j] = curMax;
                    path[i][j] = j - k + 1;
                }
            }
        }
        
        int[] res = new int[3];
        
        res[2] = path[3][nums.length - 1];
        res[1] = path[2][res[2] - 1];
        res[0] = path[1][res[1] - 1];
        
        return res;
    }
}
