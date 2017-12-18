package leetcode;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array
// 26. Remove Duplicates from Sorted Array

class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 0;
        int res = 0;
        
        while (fast < nums.length) {
            res++;
            
            while (fast < nums.length - 1 && nums[fast] == nums[fast + 1])
                fast++;
            
            nums[slow] = nums[fast];
            
            slow++;
            fast++;
        }
        
        return res;
    }
}
