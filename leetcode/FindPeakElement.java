package leetcode;

// https://leetcode.com/problems/find-peak-element/description/
// 162. Find Peak Element

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int n = nums.length;

        if (n < 2)
            return 0;

        if (n == 2)
            return nums[0] > nums[1] ? 0 : 1;

        int l = 0, r = n - 1, res = 0;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (mid == 0 || mid == n - 1)
                return mid;

            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
                return mid;
            else if (nums[mid] > nums[mid + 1] && nums[mid] < nums[mid - 1])
                r = mid;
            else
                l = mid + 1;
        }

        return l;
    }
}
