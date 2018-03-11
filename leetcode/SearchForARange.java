package leetcode;

// https://leetcode.com/problems/search-for-a-range/description/
// 34. Search for a Range

public class SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        int min = Integer.MAX_VALUE, max, l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                r = mid - 1;
                min = Math.min(min, mid);
            } else if (nums[mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }

        if (min == Integer.MAX_VALUE)
            return new int[]{-1, -1};

        max = min;

        l = min;
        r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                l = mid + 1;
                max = Math.max(max, mid);
            } else
                r = mid - 1;
        }

        return new int[]{min, max};
    }
}
