package leetcode;

// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
// 153. Find Minimum in Rotated Sorted Array

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int n = nums.length;

        if (n == 0)
            return -1;

        if (n == 1)
            return nums[0];

        if (nums[0] < nums[n - 1]) // array is sorted normally, no rotation happened
            return nums[0];

        int l = 0, r = n - 1;

        while (l < r) {
            if (nums[l] < nums[r])
                break;

            int m = l + (r - l) / 2;

            if (nums[m] < nums[r])
                r = m;
            else
                l = m + 1;
        }

        return nums[l];
    }
}
