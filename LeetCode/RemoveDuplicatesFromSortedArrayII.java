// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
// 80. Remove Duplicates from Sorted Array II

class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        
        int res = 0, slow = 0, fast = 0, cur = 1;
        while (fast < nums.length - 1) {
            while (fast < nums.length - 1 && nums[fast] == nums[fast + 1]) {
                fast++;
                cur++;
            }
            
            if (cur == 1) {
                res++;
                nums[slow] = nums[fast];
                slow++;
            } else {
                res += 2;
                nums[slow] = nums[fast];
                nums[slow + 1] = nums[fast];
                
                slow += 2;
            }
            
            cur = 1;
            fast++;
        }
        
        if (fast < nums.length && nums[fast] != nums[fast - 1]) {
            res++;
            nums[slow] = nums[fast];
        }
        
        return res;
    }
}
