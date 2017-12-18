package leetcode;

// https://leetcode.com/problems/range-sum-query-immutable/description/
// 303. Range Sum Query - Immutable

class NumArray {
    
    int[] sums;
    int[] nums;

    public NumArray(int[] nums) {
        sums = new int[nums.length];
        this.nums = nums;
        
        if (nums.length == 0)
            return;
        
        sums[0] = nums[0];
        
        for (int i = 1; i < nums.length; i++)
            sums[i] = sums[i - 1] + nums[i];
    }
    
    public int sumRange(int i, int j) {
        return sums[j] - sums[i] + nums[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
 