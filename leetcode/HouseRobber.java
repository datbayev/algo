package leetcode;

// https://leetcode.com/problems/house-robber/
// 198. HouseRobber

class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        
        int prevRobbed = 0;
        int prevNotRobbed = 0;
        
        for (int i = 0; i < n; i++) {
            int temp = prevNotRobbed;
            prevNotRobbed = Math.max(prevNotRobbed, prevRobbed);
            prevRobbed = temp + nums[i];
        }
        
        return Math.max(prevRobbed, prevNotRobbed);
    }
}
