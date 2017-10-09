// https://leetcode.com/problems/climbing-stairs/description/
// 70. Climbing Stairs

class ClimbingStairs {
    public int climbStairs(int n) {
    	if (n == 0)
    		return 1;
    	
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        
        return dp[n];
    }
}
