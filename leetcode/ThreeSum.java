package leetcode;

// https://leetcode.com/problems/3sum/description/
// 15. 3Sum

/*
First we sort initial array, then loop over it from left to right
with current position "i". Then we move two indexes until they meet:
one from i+1 towards right, the other from n-1 towards left
and try finding target sum.
*/

import java.util.*;

class ThreeSum {
    List<List<Integer>> res;
    
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3)
            return new ArrayList();
        
        int n = nums.length;
        
        res = new ArrayList();
        
        Arrays.sort(nums);
        
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            
            int target = -nums[i];
            
            int j = i + 1;
            int k = n - 1;
            
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        
        return res;
    }
}
