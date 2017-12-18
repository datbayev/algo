package leetcode;

// https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
// 81. Search in Rotated Sorted Array II

class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        
        if (n == 0)
            return false;
        
        if (n == 1)
            return target == nums[0];
        
        if (nums[0] < nums[n - 1])
            return binSearch(nums, target, 0, n - 1) != -1;
        
        int[] nums2 = new int[2 * n + 2];
        for (int i = 0; i < n; i++)
            nums2[i] = nums[i];
        
        int p1 = 0;
        int p2 = n - 1;
        
        while (p1 < n - 1 && nums[p1] >= nums2[p2]) {
            p2++;
            nums2[p2] = nums[p1];
            p1++;
        }
        
        return binSearch(nums2, target, p1, p2) != -1;
    }
    
    public int binSearch(int[] nums, int target, int start, int end) {
        int left = start;
        int right = end;
        int minIndex = -1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] < target)
                left = mid+ 1;
            else if (nums[mid] > target)
                right = mid;
            else {
                minIndex = Math.min(minIndex, mid);
                right = mid;
            }
        }
        
        if (nums[left] == target)
            return left;
        
        return minIndex;
    }
}
