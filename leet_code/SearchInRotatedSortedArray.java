package leet_code;

// https://leetcode.com/problems/search-in-rotated-sorted-array/description/
// 33. Search in Rotated Sorted Array

class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int n = nums.length;
        
        if (n == 0)
            return -1;
        
        if (n == 1)
            return nums[0] == target ? 0 : -1;
        
        if (nums[0] < nums[n - 1])
            return binSearch(nums, target, 0, n - 1);
        
        int left = 0;
        int right = n - 1;
        int min = nums[n - 1];
        int minIndex = n - 1;
        
        while (left < right) {
            int m = left + (right - left) / 2;
            
            if (min > nums[m]) {
                min = nums[m];
                minIndex = m;
            }
            
            if (nums[m] > nums[n - 1])
                left = m + 1;
            else
                right = m;
        }
        
        if (target == nums[minIndex]) // target is the minimum number
            return minIndex;
        
        int searchLeft = 0;
        int searchRight = n - 1;
        
        if (target >= nums[0])
            searchRight = minIndex;
        else
            searchLeft = minIndex;
        
        return binSearch(nums, target, searchLeft, searchRight);
    }
    
    public int binSearch(int[] nums, int target, int left, int right) {
        int l = left, r = right;
        
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] > target)
                r = m;
            else if (nums[m] < target)
                l = m + 1;
            else return m;
        }
        
        if (nums[l] == target)
            return l;
        
        return -1;
    }
}
