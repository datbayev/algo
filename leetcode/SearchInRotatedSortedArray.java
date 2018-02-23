package leetcode;

// https://leetcode.com/problems/search-in-rotated-sorted-array/description/
// 33. Search in Rotated Sorted Array

class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target)
                return mid;

            // we need to determine which side is sorted
            // "left -> mid" or "mid -> right"

            if (nums[left] <= nums[mid]) { // left to mid is sorted
                if (target <= nums[mid] && target >= nums[left]) { // lies in left sorted side
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < nums[right]) { // right to mid is sorted
                if (target >= nums[mid] && target <= nums[right]) { // list in right sorted side
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }

        return nums[left] == target ? left : -1;
    }
}
