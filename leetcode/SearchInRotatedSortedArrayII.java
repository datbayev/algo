package leetcode;

// https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
// 81. Search in Rotated Sorted Array II

class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0)
            return false;

        int left = 0;
        while (left < nums.length - 1 && nums[left] == nums[nums.length - 1])
            left++;

        int right = nums.length - 1;
        while (right > 0 && nums[right] == nums[right - 1])
            right--;

        return binSearch(nums, target, left, right);
    }

    private boolean binSearch(int[] nums, int target, int left, int right) {
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target)
                return true;

            // we need to determine which side is sorted
            // "left -> mid" or "mid -> right"
            if (nums[left] <= nums[mid]) { // left to mid is sorted
                if (target <= nums[mid] && target >= nums[left]) { // lies in left sorted side
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else { // right to mid is sorted
                if (target >= nums[mid] && target <= nums[right]) { // list in right sorted side
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }

        return nums[left] == target;
    }
}
