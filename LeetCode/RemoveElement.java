// https://leetcode.com/problems/remove-element
// 27. Remove Element

class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int ind = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[ind] = nums[i];
                ind++;
            }
        }
        
        return ind;
    }
}
