// https://leetcode.com/problems/partition-to-k-equal-sum-subsets/description/
// 698. Partition to K Equal Sum Subsets

class PartitionToKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += nums[i];
        
        if (sum % k > 0)
            return false;
        
        boolean[] visited = new boolean[n + 1];
        
        int target = sum / k;
        
        return dfs(nums, 0, target, 0, visited, k);
    }
    
    public boolean dfs(int[] nums, int index, int target, int sum, boolean[] visited, int k) {
        if (k == 1) // one last bucket with rest of the numbers
            return true;
        
        if (sum == target)
            return dfs(nums, 0, target, 0, visited, k - 1); // one bucket found, search others
        
        for (int i = index; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                
                if (dfs(nums, i + 1, target, sum + nums[i], visited, k))
                    return true;
                
                visited[i] = false;
            }
        }
        
        return false;
    }
}
