package leetcode;

// https://leetcode.com/problems/partition-equal-subset-sum/description/
// 416. Partition Equal Subset Sum

class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        return dpSingleArray(nums);
        // return dpMatrix(nums);
    }
    
    public boolean dpMatrix(int[] nums) {
        int n = nums.length;
        
        int sum = 0;
        for (int num : nums)
            sum += num;
        
        if (sum % 2 == 1)
            return false;
        
        boolean[][] dp = new boolean[n + 1][sum + 1];
        
        int target = sum / 2;
        
        for (int i = 0; i < n; i++)
            dp[i][0] = true;
        
        for (int i = 1; i < n; i++)
            for (int j = sum; j >= nums[i]; j--) {
                dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                
                if (dp[i][target])
                    return true;
            }
        
        return false;
    }
    
    private boolean dpSingleArray(int[] nums) {
        int n = nums.length;
        
        int sum = 0;
        for (int num : nums) sum += num;
        
        if (sum % 2 == 1)
            return false;
        
        boolean[] dp = new boolean[sum + 1];
        
        int target = sum / 2;
        
        dp[0] = true;

        for (int num : nums)
            for (int j = target; j >= num; j--)
                dp[j] = dp[j] || dp[j - num];
        
        return dp[target];
    }
}
